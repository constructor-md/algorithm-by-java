package com.example.demo.designcode.patterncreate.singleton;

/**
 * 懒汉和饿汉的区别：懒汉只在用到这个对象的时候才去创建这个对象（ lazy loading ），饿汉则是不管是否用到，对象都事先被创建
 * 懒汉式单例，线程不安全
 */
public class LazySingletonUnSafeDemo {

    //静态方法不能使用非静态变量，所以该变量应该是静态的
    private static LazySingletonUnSafeDemo instance;

    private LazySingletonUnSafeDemo(){}

    //无对象创建，为了直接调用方法，该方法应该是静态的
    //由于创建对象的方法本身可能被多线程访问，故线程不安全
    public static LazySingletonUnSafeDemo getInstance(){

        if (instance == null){
            instance = new LazySingletonUnSafeDemo();
        }
        return instance;
    }


}
