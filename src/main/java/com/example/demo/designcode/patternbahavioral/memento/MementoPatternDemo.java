package com.example.demo.designcode.patternbahavioral.memento;


/**
 * 备忘录模式
 *
 * 保存对象的额某个状态，便于在适当的时候恢复该对象
 * 如在某些时候需要记录独享的某个状态，使得可以允许用户取消操作，有后悔药可吃
 *
 * 解决方法：使用一个备忘录对象存储对象的状态
 *
 * 用户和备忘录管理类耦合，而与备忘录类解耦
 *
 * 核心是备忘录类以及用于管理备忘录的负责人类的设计。
 *
 * Spring Webflow（一个基于流程开发的Web框架） 中 DefaultMessageContext 类实现了 StateManageableMessageContext 接口，查看其源码可以发现其主要逻辑就相当于给 Message 备份
 *JDK、Spring和MyBatis源码中比较少见备忘录模式
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        //建立一个备忘录状态创建者
        Originator originator = new Originator();
        //建立一个备忘录管理器
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        //使用状态创建者类临时记录状态，并写入备忘录管理器
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        //获取备忘录到临时存储处（改变临时存储的original这个创建者类的属性），并使用临时存储获取该状态
        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }


}
