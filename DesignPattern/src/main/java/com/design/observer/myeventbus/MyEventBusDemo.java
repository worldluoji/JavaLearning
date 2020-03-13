package com.design.observer.myeventbus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyEventBusDemo {

    private final static int DEFAULT_THREAD_NUM = 4;

    public static void main(String[] args) {
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_THREAD_NUM));
        eventBus.register(new EmailObserver());
        eventBus.register(new MessageObserver());
        String msg = "疫情已在全球蔓延，请大家不要去意大利、韩国等地...";
        eventBus.post(msg);
        System.out.println("*****************************************");
        long id = 333;
        eventBus.post(id);
    }
}
