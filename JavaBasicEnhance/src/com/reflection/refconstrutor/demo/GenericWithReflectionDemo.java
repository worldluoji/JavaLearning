package com.reflection.refconstrutor.demo;

import com.reflection.model.Child;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class GenericWithReflectionDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method[] methods = Child.class.getDeclaredMethods();
        String msg = "hello world!!!";
        Child c = new Child();
        for (Method method:methods) {
            if (!method.isBridge()) {
                method.invoke(c, msg);
            }
        }
    }
}
