package com.design.observer.origin;

import java.util.ArrayList;
import java.util.List;

public class AbstractSubject implements Subject {
    private List<Observer> ObserverList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : ObserverList) {
            observer.update(msg);
        }
    }
}
