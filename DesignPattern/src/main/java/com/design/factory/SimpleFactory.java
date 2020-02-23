package com.design.factory;

public class SimpleFactory {
    public static Fruit createFruit(String fruitName, String address, String quality) {
        switch (fruitName) {
            case "苹果":
                return new Apple(address, quality);
            case "橙子":
                return new Orange(address, quality);
            default:
                System.err.println("Unknown fruit");
                return null;
        }
    }
}
