package com.design.observer.origin;

/**
*  创建型设计模式主要解决“对象的创建”问题，结构型设计模式主要解决“类或对象的组合或组装”问题，
 *  那行为型设计模式主要解决的就是“类或对象之间的交互”问题。 观察者模式就是最常用的行为模式。
* */
public class SimpleObserverDemo {
    public static void main(String[] args) {
        Subject sb = new DefaultSubject();
        sb.registerObserver(new SimpleObserver());
        sb.registerObserver(new SimpleObserver2());
        sb.notifyObservers("由于疫情影响，请继续封闭小区");
    }
}
