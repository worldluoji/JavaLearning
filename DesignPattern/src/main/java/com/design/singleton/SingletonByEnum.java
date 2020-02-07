package com.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
* 枚举本身就是单例的
* */
public enum SingletonByEnum {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.getAndIncrement();
    }
}
