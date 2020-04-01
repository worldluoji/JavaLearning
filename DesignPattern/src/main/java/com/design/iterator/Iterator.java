package com.design.iterator;


/**
* 总结下来就三句话：迭代器中需要定义 hasNext()、currentItem()、next() 三个最基本的方法。
 * 待遍历的容器对象通过依赖注入传递到迭代器类中。
 * 容器通过 iterator() 方法来创建迭代器。
* */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    E currentItem();
}
