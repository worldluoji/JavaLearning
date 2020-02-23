package com.design.factory;

public class TestSimpleFactory {
    public static void main(String[] args) {
        Fruit fruit =  SimpleFactory.createFruit("苹果","盐源", "特级");
        if (fruit != null) {
            fruit.show();
        }
    }
}
