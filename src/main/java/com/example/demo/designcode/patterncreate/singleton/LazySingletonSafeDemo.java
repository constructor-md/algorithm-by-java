package com.example.demo.designcode.patterncreate.singleton;

/**
 * 懒汉式，线程安全
 */
public class LazySingletonSafeDemo {

    private static LazySingletonSafeDemo instance;

    private LazySingletonSafeDemo(){}

    //使用同步锁,加在一个静态方法上，成为一个类锁，该方法被多线程调用时将会保持同步
    public static synchronized LazySingletonSafeDemo getInstance(){
        if (instance == null){
            instance = new LazySingletonSafeDemo();
        }
        return instance;
    }
    /*
     * 加上同步锁之后，多线程获取单例时会导致其他线程卡住排队（非常正常，如果两个线程拿到同一个对象，若修改其中的值，仍会造成多线程问题）
     * 该方法使用不是特别频繁，对该方法性能要求不高时使用
     */

}
