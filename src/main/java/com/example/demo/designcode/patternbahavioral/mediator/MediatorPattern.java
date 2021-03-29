package com.example.demo.designcode.patternbahavioral.mediator;

/**
 * 中介者模式
 *   行为型模式
 *
 *  降低多个对象和类之间的通信复杂性
 *  使用一个中介者类，处理不同类之间的通信
 *
 *  如果使用类之间的通信直接耦合，就会导致依赖关系大量复杂，难以维护和跟踪
 *  使用中介者类将网状分离星状
 *  降低了类依赖的复杂度， 类之间得到解耦（中介者类中可以写对象之间的依赖装配）
 *  符合迪米特法则，即最少知识原则，一个类只和中介者类通信，而不必知道其他类。对其他对象尽可能少了解，解耦合
 *
 *  如MVC框架中， model和视图之间的中介者即为Controller，负责视图和数据之间的通信
 *
 *  关键： 对象之间的通信封装到一个类中单独处理
 *
 * 缺点： 中介者本身会越变越大，也会复杂难以维护
 *
 * 使用场景：
 *          对象之间的依赖关系复杂导致难以复用对象（中介者管理依赖数据）
 *          通过一个类封装多个类的行为，不想生成太多子类
 *
 *
 *
 */
public class MediatorPattern {


    public static void main(String[] args) {

        User robert = new User("robert");
        User john = new User("john");


        robert.sendMessage("Hi john");
        john.sendMessage("Hi robert");

    }



}
