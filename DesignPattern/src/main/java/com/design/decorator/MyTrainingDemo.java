package com.design.decorator;

import com.design.decorator.interfaces.ITraining;

public class MyTrainingDemo {
    public static void main(String[] args) {
        ITraining training = new Training();
        FullTrain fullTrain = new FullTrain(training);
        fullTrain.train();
    }
}
