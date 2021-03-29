package com.example.demo.designcode.patternbahavioral.observer;

/**
 * 观察者模式
 *  行为型模式
 *
 *  定义对象的一对多的依赖关系，
 *  当一个对象发生改变是，所有依赖于它的对象都得到通知并被自动更新
 *  同时耦合度降低，不需要相互实体依赖，因为被观察者和观察者的抽象类耦合
 *
 * 关键：抽象类中有List存放观察者
 *
 * 观察者和被观察者抽象耦合
 * 建立了一套通知的触发机制
 *
 * 缺点：
 *      如果被观察者对象有很多观察者，通知费时
 *      如果观察者和被观察者之间存在循环依赖，则观察目标通知会导致循环调用，系统崩溃风险
 *      观察者只知道目标变化了，但是不知道怎么发生了变化
 *
 * 使用场景：
 *      系统中需要触发链
 *      对象要通知其他对象而不必知道都是谁
 *      独享的改变要导致其他的对象改变，而不必知道都是谁，降低了连环改变的耦合度
 *
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexObserver(subject);

        subject.setState(11);
        subject.setState(15);

    }


}
