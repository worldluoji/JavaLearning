package com.design.adapter;

/**
* 使用继承来适配
 * 只需要重写需要适配的方法，不需要适配的方法和弗雷保持一致就可以了
* */
public class AdapterByExtend extends Adaptee {
    @Override
    public void say(String msg) {
        System.out.println("adapter:" + msg);
    }
}
