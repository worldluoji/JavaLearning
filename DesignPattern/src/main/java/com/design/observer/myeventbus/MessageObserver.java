package com.design.observer.myeventbus;

public class MessageObserver {
    @Subscribe
    public void receive(String msg) {
        System.out.println("接收到短信,内容如下：" + msg);
    }
}
