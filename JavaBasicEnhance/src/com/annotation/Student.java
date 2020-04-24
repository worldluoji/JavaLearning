package com.annotation;

public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    /**
    * 方法覆写，不能自动继承注解
    * */
    @Override
    public void say() {
        System.out.println("我只是一个学生......");
    }
}
