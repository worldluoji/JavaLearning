package com.design.strategy;

@MyStrategy(type="defend")
public class DefendStrategy implements Strategy {
    @Override
    public void strategy() {
        System.out.println("上将潘凤表示防守!!!");
    }
}
