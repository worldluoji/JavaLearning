package com.design.observer.guva;

import com.google.common.collect.Lists;

/**
*  EventBus 翻译为“事件总线”，它提供了实现观察者模式的骨架代码。
 * 我们可以基于此框架，非常容易地在自己的业务场景中实现观察者模式，不需要从零开始开发。
 * 其中，Google Guava EventBus 就是一个比较著名的 EventBus 框架，它不仅仅支持异步非阻塞模式，同时也支持同步阻塞模式
 * EventBus eventBus = new EventBus(); // 同步阻塞模式
 * EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(8))；// 异步阻塞模式
* */
public class GuvaEventBusDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.registerObservers(Lists.newArrayList(new UserRegNotifyObserver()));
        userController.register("luojiTestAccount", "123456");
    }
}
