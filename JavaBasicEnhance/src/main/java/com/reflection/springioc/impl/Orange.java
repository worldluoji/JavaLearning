package com.reflection.springioc.impl;

import com.reflection.springioc.interfaces.fruit;

public class Orange implements fruit {
    @Override
    public void eat() {
        System.out.println("eating orange");
    }
}
