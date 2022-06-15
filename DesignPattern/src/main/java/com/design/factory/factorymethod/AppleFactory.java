package com.design.factory.factorymethod;

import com.design.factory.Apple;
import com.design.factory.Fruit;

// 工厂方法模式将创建“分离”了，更符合开放封闭原则
public class AppleFactory implements FactoryMethod {

    @Override
    public Fruit create(String address, String quality) {
       return new Apple(address, quality);
    }
    
}
