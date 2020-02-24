package com.design.decorator;

import com.design.decorator.interfaces.ITraining;

public abstract class BaseDecorator implements ITraining {
    private ITraining iTraining;
    public BaseDecorator(ITraining iTraining) {
        this.iTraining = iTraining;
    }
    @Override
    public void train() {
        if (iTraining != null) {
            iTraining.train();
        }
    }
}
