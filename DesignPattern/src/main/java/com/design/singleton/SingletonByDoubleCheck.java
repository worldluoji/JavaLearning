package com.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
* 解决了纯懒汉模式加锁效率低下的问题
* */
public class SingletonByDoubleCheck {
    private AtomicLong id = new AtomicLong(0);
    private static SingletonByDoubleCheck instance = null;
    private SingletonByDoubleCheck() {}

    public static SingletonByDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonByDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonByDoubleCheck();
                }
            }
        }
        return instance;
    }
    public long getId() {
        return id.getAndIncrement();
    }
}
