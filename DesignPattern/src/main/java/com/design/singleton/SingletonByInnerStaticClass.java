package com.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class SingletonByInnerStaticClass {
    private AtomicLong id = new AtomicLong(0);

    private SingletonByInnerStaticClass() {}

    private static class SingletonHolder {
        private final static SingletonByInnerStaticClass instance = new SingletonByInnerStaticClass();
    }

    public static SingletonByInnerStaticClass getInstance() {
        return SingletonHolder.instance;
    }
    public long getId() {
        return id.getAndIncrement();
    }
}
