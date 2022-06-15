package com.design.factory.factorymethod;

import com.design.factory.Fruit;

public interface FactoryMethod {
    Fruit create(String address, String quality);
}
