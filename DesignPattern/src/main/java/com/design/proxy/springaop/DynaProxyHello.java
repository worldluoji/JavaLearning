package com.design.proxy.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyHello implements InvocationHandler {
    /**
    * 代理,即包在外面那层,前后处理
    * */
    private Object proxy;

    /**
    * 主体方法对象
    * */
    private Object delegate;

    public Object bind(Object delegate, Object proxy) {
        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
                this.delegate.getClass().getInterfaces(), this);
    }

    /**
    * method:执行的方法
     * *args:方法参数
     * proxy:代理
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        try {
            Class<?> clazz = this.proxy.getClass();
            // 方法执行之前
            Method start = clazz.getDeclaredMethod("beforeMethod", Method.class);
            if (start != null) {
                start.invoke(this.proxy, method);
            }

            // 主体方法
            result = method.invoke(this.delegate, args);

            // 方法执行之后
            Method end = clazz.getDeclaredMethod("afterMethod", Method.class);
            if (end != null) {
                end.invoke(this.proxy, method);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
