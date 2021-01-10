package com.example.demo.designcode.patterncreate.factorymethod;

public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {

        //通过传递类型信息获取类
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

    }

}
