package com.example.demo.designcode.patternstructure.facade;

/**
 * 外观类
 */
public class ShapeMapper {

    private Shape square;
    private Shape rectangle;

    public ShapeMapper(){
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }


}
