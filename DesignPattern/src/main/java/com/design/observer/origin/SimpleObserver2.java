package com.design.observer.origin;

import com.design.utils.output.ConsoleOutputUtil;
import com.design.utils.output.OutputUtil;

public class SimpleObserver2 implements Observer {
    @Override
    public void update(String msg) {
        OutputUtil outputUtil = new ConsoleOutputUtil();
        outputUtil.output(msg, "dev");
    }
}
