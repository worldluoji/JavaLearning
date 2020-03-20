package com.design.template.callback;

public class BussinessClass {
    public void process(ICallback callback) {
        System.out.println("处理xxx业务");
        // 业务处理完后处理附加功能，比如发消息通知等
        callback.methodToCallback();
    }
}
