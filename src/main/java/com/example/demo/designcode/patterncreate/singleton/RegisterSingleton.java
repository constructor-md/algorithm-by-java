package com.example.demo.designcode.patterncreate.singleton;

/**
 * 登记式单例/静态内部类，线程安全
 */
public class RegisterSingleton {

    private RegisterSingleton(){}


    private static class RegisterSingletonHolder{
        private static final RegisterSingleton INSTANCE = new RegisterSingleton();
    }

    public static RegisterSingleton getInstance(){
        return RegisterSingletonHolder.INSTANCE;
    }

    /*
    利用了Java的类加载机制保证初始化只有一个实例，与饿汉式不同在于，饿汉一加载就有实例，没有lazy
    这种方法在RegisterSingleton被装载时，instance不一定被初始化，因为RegisterSingletonHolder类没有被主动使用
    这使得在实例化非常耗费资源时可使用这个方法。
     */

    /*
    类加载机制说明：

     */

}
