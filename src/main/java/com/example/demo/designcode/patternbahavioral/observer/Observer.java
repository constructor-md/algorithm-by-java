package com.example.demo.designcode.patternbahavioral.observer;


/**
 * 抽象观察者类
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
