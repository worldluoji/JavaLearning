package com.design.decorator;

import com.design.decorator.interfaces.ITraining;

/**
 * 装饰器模式和代理模式的区别：
*  代理模式中，代理类附加的是跟原始类无关的功能，
 * 而在装饰器模式中，装饰器类附加的是跟原始类相关的增强功能
* */
public class MyTrainingDemo {
    public static void main(String[] args) {
        ITraining training = new Training();
        FullTrain fullTrain = new FullTrain(training);
        fullTrain.train();
    }
}
