package com.example.demo.designcode.patternstructure.dynamicproxy;

import java.lang.reflect.Proxy;


/**
 * 动态代理
 * 与静态代理不同在于使用反射生成代理类
 *
 * 如：jdk动态代理中
 *     {@link java.lang.reflect.Proxy} 负责生成动态代理类和对象
 *     {@link java.lang.reflect.InvocationHandler} 通过invoke方法实现对真实对象的代理访问
 *     每次通过proxy生成的对象都要指定对应的处理器对象
 *
 */
public class DynamicProxyDemo {


    public static void main(String[] args) {

        //真实对象
        Subject realSubject = new RealSubject();

        //将被代理对象传入代理处理器中
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(realSubject);

        //通过jdk的Proxy生成代理对象，并指定处理器
        //第一个参数为无所谓是哪个类加载器，都是ApplicationClassLoader
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, invocationHandler);

        //获取该对象的类加载器
//        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        //获取该对象实现的接口
//        Class[] interfaces = realSubject.getClass().getInterfaces();

//        System.out.println(interfaces[0]);

        //使用类加载器、实现接口和处理类创建代理类
//        Subject subject = (Subject) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

//        String hello = subject.sayHello("fuck you boy");
//
//        String bye = subject.sayBye("today is great");

//        System.out.println(hello);

        //System.out.println(bye);

        //调用代理方法
        proxyClass.sayBye("by");
        proxyClass.sayHello("baby");


    }

    /**
     * {@link Class} 类  为类型信息类  即type
     * 由JVM内部生成，除了六个基本数据类型，其他所有类型都是Class
     *
     *
     */


}
