package com.example.demo.designcode.patternbahavioral.proxy;

/**
 * 代理模式
 *  行为型模式  在外界访问实际对象之前，插手做若干操作
 *  加入了中间层
 *
 *  代理类和被代理类实现同一接口，且被代理类的所有方法都要在接口中重写一遍
 *  以便代理类代理调用方法
 *  这也叫做静态代理 因为接口方法不能动态改变，一旦被代理类增减方法，接口和代理都要修改
 *  如果有新的类需要代理，同样需要写新的接口和代理内容  所以叫静态代理
 *  动态代理则可以动态生成代理类，不需要受到接口的限制，原因是使用了反射直接读取了被代理类的内涵信息
 *
 *  和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
 *  和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
 *
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {

        //实际对象为proxyImage
        Image image = new ProxyImage("test_10mb.jpg");
        //第一次调用时，new 一个RealImage对象，象征从磁盘加载 该对象随后被存在代理对象供实现代理
        image.display();
        //代理对象可以使用缓存对象做若干事先操作
        //此处只是演示了代理在方法调用时作为了中间层，可以进行若干操作
        image.display();

    }

}
