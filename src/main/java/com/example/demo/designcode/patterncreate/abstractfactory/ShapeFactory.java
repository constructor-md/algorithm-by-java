package com.example.demo.designcode.patterncreate.abstractfactory;

/**
 * 具体工厂类，根据传入参数返回不同的产品
 */
public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String colorType) {
        return null;
    }

    public Shape getShape(String shapeType){

        if (shapeType == null){
            return null;
        }
        //不直接把null和无内容进行判断是因为会报空指针异常，equals和equalsIgnoreCase的前置容易报空指针，所以要把必然存在值的放在前面，同时要注意不要忽略了空指针的情况
        if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        return null;
    }

}
