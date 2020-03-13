package com.design.observer.guva;

import com.google.common.eventbus.Subscribe;

public class UserRegNotifyObserver {
    @Subscribe
    public void doNotify(String userId) {
        System.out.println(Thread.currentThread() + "：" + userId + "您已注册成功，请登录邮箱激活");
    }
}
