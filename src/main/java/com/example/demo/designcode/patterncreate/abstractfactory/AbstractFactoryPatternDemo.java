package com.example.demo.designcode.patterncreate.abstractfactory;

public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        //通过抽象类获取工厂，由于没有转型，根据父类抽象方法直接获取工厂，调用方法时如果错了，由于工厂并不存在则报空指针
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();


    }

}
