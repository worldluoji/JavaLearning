package com.reflection.springioc;

import com.reflection.springioc.interfaces.fruit;

public class MySpingFactory {
    public static fruit getInstance(String className) {
        fruit f = null;
        try {
            f = (fruit)Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
