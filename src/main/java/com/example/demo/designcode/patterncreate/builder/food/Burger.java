package com.example.demo.designcode.patterncreate.builder.food;


import com.example.demo.designcode.patterncreate.builder.pack.Wrapper;
import com.example.demo.designcode.patterncreate.builder.abstractClass.Item;
import com.example.demo.designcode.patterncreate.builder.abstractClass.Packing;

/**
 * 食品超类的拓展
 */
public abstract class Burger implements Item {


    @Override
    public abstract float getPrice();

    @Override
    public Packing getPacking() {
        return new Wrapper();
    }
}
