package com.design.decorator;

import com.design.decorator.interfaces.ITraining;

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
