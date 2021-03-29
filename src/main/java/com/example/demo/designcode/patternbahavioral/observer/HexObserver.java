package com.example.demo.designcode.patternbahavioral.observer;


/**
 * 具体观察者类
 */
public class HexObserver extends Observer {


    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toOctalString(subject.getState()));
    }


}
