package com.design.share;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;


/**
*  池化技术中的“复用”可以理解为“重复使用”，主要目的是节省时间（比如从数据库池中取一个连接，不需要重新创建）。
 * 在任意时刻，每一个对象、连接、线程，并不会被多处使用，而是被一个使用者独占，当使用完成之后，放回到池中，再由其他使用者重复利用。
 * 享元模式中的“复用”可以理解为“共享使用”，在整个生命周期中，都是被所有使用者共享的，主要目的是节省空间。
 * 对象池，连接池也可以看作广泛意义上的享元模式
 *
 * 实际上，享元模式对 JVM 的垃圾回收并不友好。因为享元工厂类一直保存了对享元对象的引用，这就导致享元对象在没有任何代码使用的情况下，也并不会被 JVM 垃圾回收机制自动回收掉。
 * 因此，在某些情况下，如果对象的生命周期很短，也不会被密集使用，利用享元模式反倒可能会浪费更多的内存。
 * 所以，除非经过线上验证，利用享元模式真的可以大大节省内存，否则，就不要过度使用这个模式，为了一点点内存的节省而引入一个复杂的设计模式，得不偿失啊。
* */
public class ObjectPool<T, R> {
    // 对象池里对象的个数
    private int objCount;
    private final Vector<T> pool;
    private final Semaphore sem;

    public ObjectPool(int objCount, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (objCount <= 0 || clazz == null) {
            throw new IllegalArgumentException();
        }
        this.objCount = objCount;
        sem = new Semaphore(this.objCount);
        pool = new Vector<>(objCount);
        for (int i = 0; i < objCount; i++) {
            pool.add(clazz.newInstance());
        }
    }

    public ObjectPool(int objCount, Class<T> clazz, Class<?>[] paramTypes, Object[] params) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (objCount <= 0 || clazz == null || paramTypes == null || params == null) {
            throw new IllegalArgumentException();
        }
        this.objCount = objCount;
        sem = new Semaphore(this.objCount);
        pool = new Vector<>(objCount);
        for (int i = 0; i < objCount; i++) {
            T t = clazz.getConstructor(paramTypes)
                    .newInstance(params);
            pool.add(t);
        }
    }

    public R exec(Function<T,R> function) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public int getObjCount() {
        return objCount;
    }
}
