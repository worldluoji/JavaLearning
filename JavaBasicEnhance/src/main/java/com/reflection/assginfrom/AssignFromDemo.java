package com.reflection.assginfrom;

public class AssignFromDemo {
    public static void main(String[] args) {
        System.out.println("Strategy assign from A : " + Strategy.class.isAssignableFrom(ConcreteStrategyA.class));
        System.out.println("Strategy assign from B : " + Strategy.class.isAssignableFrom(ConcreteStrategyB.class));
        System.out.println("ParentClass assign from B : " + ParentClass.class.isAssignableFrom(ConcreteStrategyB.class));
        System.out.println("A assign from B : " + ConcreteStrategyA.class.isAssignableFrom(ConcreteStrategyB.class));
    }
}
