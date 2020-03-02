package com.design.proxy.springaop;

import com.design.proxy.springaop.impl.Hello;
import com.design.proxy.springaop.impl.Operation;
import com.design.proxy.springaop.interfaces.IHello;

public class SpringAopDemo {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello().bind(new Hello(), new Operation());
        hello.sayHello("luoji");
        hello.sayGoodbye("luoji");
    }
}
