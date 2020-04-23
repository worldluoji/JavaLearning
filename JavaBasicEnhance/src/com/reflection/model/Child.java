package com.reflection.model;

public class Child extends Parent<String> {
    @Override
    public void say(String msg) {
       System.out.println("child:" + msg);
    }
}
