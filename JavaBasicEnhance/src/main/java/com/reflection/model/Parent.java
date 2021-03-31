package com.reflection.model;

public class Parent<T> {
    public void say(T msg) {
        System.out.println("parent" + msg);
    }


}
