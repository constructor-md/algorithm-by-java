package com.example.demo.designcode.patternstructure.facade;

/**
 * 外观模式
 *  结构型模式
 *
 * 隐藏了系统的复杂性，向外界提供一个可以访问系统的接口
 *
 * 关键：在客户端和复杂系统之间再加一层，将调用顺序和依赖等处理好
 *
 * 使用场景：
 *      为复杂系统或者子系统提供外界访问的模块
 *      子系统相对独立
 *      直接暴露内层系统会带来操作上的复杂，降低低水平人员带来的风险
 *
 * 减少了系统间相互依赖，提升灵活性和安全性
 * 但是不符合开闭原则，需要修改功能的时候，由于内部系统的拖累和外部要求，不好继承和重写
 *
 *
 */
public class FacadePatternDemo {


    public static void main(String[] args) {
        ShapeMapper shapeMapper = new ShapeMapper();
        shapeMapper.drawRectangle();
        shapeMapper.drawSquare();
    }

}
