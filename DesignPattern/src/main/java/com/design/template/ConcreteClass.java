package com.design.template;

import java.util.Random;
import java.util.UUID;

public class ConcreteClass extends TemplateClass {
    @Override
    protected boolean templateMethod() {
        System.out.println("执行模板方法");
        Random r = new Random();
        int num = r.nextInt();
        return num % 2 == 0;
    }
}
