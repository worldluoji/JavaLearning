package com.design.decorator;

import com.design.decorator.interfaces.ITraining;

public class Training implements ITraining {
    @Override
    public void train() {
        System.out.println("锻炼：俯卧撑，仰卧起坐。。。");
    }
}
