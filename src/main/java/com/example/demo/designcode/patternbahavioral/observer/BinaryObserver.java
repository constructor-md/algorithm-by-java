package com.example.demo.designcode.patternbahavioral.observer;

/**
 * 具体观察者类
 * 构建时写入被观察者的List中
 *
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toOctalString(subject.getState()));
    }
}
