package com.design.strategy;

public class AttackStrategy implements Strategy {
    @Override
    public void strategy() {
        System.out.println("关羽向吕布发送了进攻");
    }
}
