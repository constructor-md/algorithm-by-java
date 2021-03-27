package com.example.demo.designcode.patterncreate.abstractfactory;


import com.example.demo.designcode.patterncreate.abstractfactory.factory.FactoryProducer;
import com.example.demo.designcode.patterncreate.abstractfactory.item.Shape;

/**
 * 抽象工厂方法
 * 创建型模式 工厂方法通过抽象产品类，使用工厂类的方法可以得到多种子产品
 * 抽象工厂方法通过抽象工厂类，并使用抽象工厂提供器获取具体工厂
 * 再通过具体的工厂方法获取子产品
 * 再一层抽象，管理多个产品组
 *
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        //通过抽象类获取工厂，由于没有转型，根据父类抽象方法直接获取工厂，调用方法时如果错了，由于工厂并不存在则报空指针
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

    }

}
