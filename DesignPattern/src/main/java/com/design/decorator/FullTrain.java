package com.design.decorator;

import com.design.decorator.interfaces.ITraining;


/**
* 装饰实现类要实现和被装饰类同样的接口或继承被装饰类
* */
public class FullTrain extends  BaseDecorator {
    public FullTrain(ITraining iTraining) {
        super(iTraining);
    }

    @Override
    public void train() {
        System.out.println("做点热身活动...");
        super.train();
        System.out.println("再跑跑步吧...");
    }
}
