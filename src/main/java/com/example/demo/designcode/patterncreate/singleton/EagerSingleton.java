package com.example.demo.designcode.patterncreate.singleton;

/**
 * 饿汉式，线程安全
 */
public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    //为静态变量赋初值，其实就已经是在类加载时新建了对象
//    static {
//        instance = new EagerSingleton();
//    }

    private EagerSingleton(){}

    //特点是使用静态代码块生成单例，类加载时直接产生，不会有多线程情况
    public static EagerSingleton getInstance(){
        return instance;
    }

}
