package com.example.demo.designcode.patternbahavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，变化时更新所有观察者
 */
public class Subject {

    private List<Observer> observerList = new ArrayList<>();
    private int state;

    public void notifyAllObservers() {
        for (Observer observer :observerList) {
            observer.update();
        }
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
}
