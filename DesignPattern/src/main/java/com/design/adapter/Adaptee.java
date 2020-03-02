package com.design.adapter;

/**
* 被适配的基础类
* */
public class Adaptee implements ITarget{
    @Override
    public void hello() {
        System.out.println("Hello World!!!");
    }

    @Override
    public void say(String msg) {
        System.out.println(msg);
    }
}
