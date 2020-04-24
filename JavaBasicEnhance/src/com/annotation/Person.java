package com.annotation;

@MyAnnotation(value = "person")
public class Person {
    private String name;
    private int age;

    @MyAnnotation(value = "person method")
    public void say() {
        System.out.println("我是" + name + "，今年" + age + "岁");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
