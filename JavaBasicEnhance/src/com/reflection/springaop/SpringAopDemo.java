package com.reflection.springaop;

import com.reflection.springaop.impl.Hello;
import com.reflection.springaop.impl.Operation;
import com.reflection.springaop.interfaces.IHello;

public class SpringAopDemo {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello().bind(new Hello(), new Operation());
        hello.sayHello("luoji");
        hello.sayGoodbye("luoji");
    }
}
