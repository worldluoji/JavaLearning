package com.design.observer.myeventbus;

public class EmailObserver {
    @Subscribe
    public void receive(String msg) {
        System.out.println("接收到Email,内容如下：" + msg);
    }

    @Subscribe
    public void delete(Long id) {
        System.out.println("邮件" + id + "已被删除");
    }
}
