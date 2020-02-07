package com.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
* 无法实现懒加载，在类加载时即实例化对象
* */
public class SingletonByHungry {
    private AtomicLong id = new AtomicLong(0);
    private final static SingletonByHungry instance = new SingletonByHungry();
    private SingletonByHungry() {}

    public static SingletonByHungry getInstance() {
        return instance;
    }
    public long getId() {
        return id.getAndIncrement();
    }
}
