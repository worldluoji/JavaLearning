package com.reflection.assginfrom;

public class ConcreteStrategyB extends ParentClass implements Strategy {
    @Override
    public void process() {
        System.out.println("防守...");
    }

    public void defend() {
        System.out.println("使用守护之光");
    }

    @Override
    public void say(String msg) {
        super.say(msg);
        this.defend();
    }
}
