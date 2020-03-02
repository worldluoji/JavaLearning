package com.design.proxy.springaop.impl;

import com.design.proxy.springaop.interfaces.IHello;

public class Hello implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " +  name);
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye " +  name);
    }
}
