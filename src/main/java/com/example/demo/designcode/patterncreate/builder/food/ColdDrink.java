package com.example.demo.designcode.patterncreate.builder.food;

import com.example.demo.designcode.patterncreate.builder.abstractClass.Item;
import com.example.demo.designcode.patterncreate.builder.abstractClass.Packing;
import com.example.demo.designcode.patterncreate.builder.pack.Bottle;

public abstract class ColdDrink implements Item {


    @Override
    public abstract float getPrice();

    @Override
    public Packing getPacking() {
        return new Bottle();
    }
}
