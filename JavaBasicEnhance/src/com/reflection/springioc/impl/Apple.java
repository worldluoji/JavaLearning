package com.reflection.springioc.impl;

import com.reflection.springioc.interfaces.fruit;

public class Apple implements fruit {
    @Override
    public void eat() {
        System.out.println("eating apple");
    }
}
