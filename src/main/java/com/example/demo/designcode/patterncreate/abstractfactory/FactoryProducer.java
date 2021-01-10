package com.example.demo.designcode.patterncreate.abstractfactory;

/**
 * 工厂生成器，根据传入参数返回不同的工厂
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryType){

        if (factoryType == null){
            return null;
        }
        if ("COLOR".equalsIgnoreCase(factoryType)){
            return new ColorFactory();
        }
        if ("SHAPE".equalsIgnoreCase(factoryType)){
            return new ShapeFactory();
        }

        return null;
    }

}
