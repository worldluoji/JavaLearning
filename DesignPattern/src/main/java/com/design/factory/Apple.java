package com.design.factory;

public class Apple extends AbstractFruit {
    public Apple(String address, String quality) {
        setName("苹果");
        setAddress(address);
        setQuality(quality);
    }
}
