package com.design.observer.guva;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.Executors;

public class UserController {
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 4;
    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void registerObservers(List<Object> observers) {
        if (CollectionUtils.isEmpty(observers)) {
            throw new IllegalArgumentException();
        }
        for (Object obj:observers) {
            eventBus.register(obj);
        }
    }

    /**
    * 模拟注册
    * */
    public void register(String userId, String password) {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException();
        }
        System.out.println(Thread.currentThread() + ":用户" + userId + "注册而成功");
        eventBus.post(userId);
    }
}
