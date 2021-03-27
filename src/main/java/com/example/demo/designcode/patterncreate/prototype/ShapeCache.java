package com.example.demo.designcode.patterncreate.prototype;

import java.util.Hashtable;

public class ShapeCache {


    private static Hashtable<String, AbstractShape> shapeHashtable = new Hashtable<>();


    //返回缓存的克隆对象
    public static AbstractShape getShape(String  shapeId){
        AbstractShape cacheShape = shapeHashtable.get(shapeId);
        return (AbstractShape) cacheShape.clone();
    }

    //从数据库或什么地方或的对象时，将该对象缓存到hashTable中
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeHashtable.put(circle.getId(), circle);
    }


}
