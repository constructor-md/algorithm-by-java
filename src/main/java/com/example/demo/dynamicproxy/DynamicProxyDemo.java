package com.example.demo.dynamicproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {


    public static void main(String[] args) {

        //真实对象
        Subject realSubject = new RealSubject();

        //将被代理对象传入代理处理器中
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(realSubject);

        //获取该对象的类加载器
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        //获取该对象实现的接口
        Class[] interfaces = realSubject.getClass().getInterfaces();

        System.out.println(interfaces[0]);

        //使用类加载器、实现接口和处理类创建代理类
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

        String hello = subject.sayHello("fuck you boy");

        //String bye = subject.sayBye("today is great");

        System.out.println(hello);

        //System.out.println(bye);




    }




}
