package com.reflection.springaop.impl;

import com.reflection.springaop.Logger;
import com.reflection.springaop.constants.LogLevel;
import com.reflection.springaop.interfaces.IOperation;

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
