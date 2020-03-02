package com.design.proxy.springaop.impl;

import com.design.proxy.springaop.Logger;
import com.design.proxy.springaop.constants.LogLevel;
import com.design.proxy.springaop.interfaces.IOperation;

import java.lang.reflect.Method;

public class Operation implements IOperation {
    @Override
    public void beforeMethod(Method method) {
        Logger.logging(LogLevel.INFO, method.getName() + " method start");
    }

    @Override
    public void afterMethod(Method method) {
        Logger.logging(LogLevel.INFO, method.getName() + " method end");
    }
}
