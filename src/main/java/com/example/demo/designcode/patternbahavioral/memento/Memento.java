package com.example.demo.designcode.patternbahavioral.memento;

/**
 * 备忘录类
 *
 * 有一个记录了对象某种状态的属性，封装成备忘录类，使用备忘录管理器管理
 *
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

}
