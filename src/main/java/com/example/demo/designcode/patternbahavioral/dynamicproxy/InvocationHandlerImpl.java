package com.example.demo.designcode.patternbahavioral.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理处理器
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Subject subject;

    public InvocationHandlerImpl(Subject subject){
        this.subject = subject;
    }

    /**
     *
     * 通过代理类调用时，通过该方法进行处理并最终调用被代理类方法
     * @param proxy 代理类
     * @param method 外界正在调用的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //可以做前置操作
        System.out.println("调用代理类 ====>");

        //当代理对象调用真实对象的方法时，会自动的转发到代理对象关联的handler对象的invoke方法来进行调用
        Object returnValue = method.invoke(subject, args);

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("调用后 ====>");

        return returnValue;
    }

    /**
     * 通过查看源码可知
     * method.invoke方法，经由{@link Method#invoke(Object, Object...)} 方法检查了方法的访问权限
     * 然后调用了 {@link sun.reflect.NativeMethodAccessorImpl#invoke0}方法，该方法最终由jvm底层代码实现
     * 得以调用到对应方法
     *
     * Method对象中包含有被代理对象指定方法（正在被调用的那个）的信息
     * 包括方法名，修饰符，返回值，参数列表等用于在程序运行中动态获取方法信息
     *
     * 小注：其中有个isBridge的方法判断该方法是否为桥接方法 涉及到桥接方法模式
     *
     */
}
