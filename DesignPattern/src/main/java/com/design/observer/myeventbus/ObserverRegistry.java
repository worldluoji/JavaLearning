package com.design.observer.myeventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {
    // key为event类型,可以是类, 基本数据类型；value为这一事件触发要调用哪些方法做事情
    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> allObserverActionsMap = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : allObserverActionsMap.entrySet()) {
            Class<?> eventType = entry.getKey();
            if (registry.get(eventType) == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
            }
            registry.get(eventType).addAll(entry.getValue());
        }
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> methodList = Lists.newArrayList();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                methodList.add(method);
            }
        }
        return methodList;
    }

    /**
    * 通过事件找到其对应有哪些动作需要通知观察者
     * 有两个Class类型的类象，a.isAssignableFrom(b)这两个对象如果满足以下条件则返回true，否则返回false：
     *     a对象所对应类信息是b对象所对应的类信息的父类或者是父接口，简单理解即a是b的父类或接口
     *     a对象所对应类信息与b对象所对应的类信息相同
     *
     * //说明：Protocol是接口，DubboProtocol是Protocol的实现
     * Class<?> protocolClass = Protocol.class ;
     * Class<?> dubboProtocolClass = DubboProtocol.class ;
     *  protocolClass.isAssignableFrom(dubboProtocolClass )) ;   //返回true
     *  protocolClass.isAssignableFrom(protocolClass )) ;        //返回true
     *  dubboProtocolClass.isAssignableFrom(protocolClass )) ;   //返回false
    * */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObserverActions = Lists.newArrayList();
        Class<?> eventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> key = entry.getKey();
            if (eventType.isAssignableFrom(key)) {
                matchedObserverActions.addAll(entry.getValue());
            }
        }
        return matchedObserverActions;
    }

    /**
    * 一个Observer下有多个方法，都可以用@Subscribe注解订阅相同或不同的事件
     * 这个方法相当于是找到该观察者下对应不同类型入参的方法，该做什么事
    * */
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] eventTypes = method.getParameterTypes();
            Class<?> eventType = eventTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, Lists.newArrayList());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }
}
