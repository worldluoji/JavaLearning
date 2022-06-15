package com.design.factory.factorymethod;

import com.design.factory.Fruit;
import com.design.factory.Orange;

public class OrangeFactory implements FactoryMethod {

    @Override
    public Fruit create(String address, String quality) {
        return new Orange(address, quality);
    }
    
}
