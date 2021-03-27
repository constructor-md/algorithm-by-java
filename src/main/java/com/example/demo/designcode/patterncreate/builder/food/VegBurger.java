package com.example.demo.designcode.patterncreate.builder.food;

import com.example.demo.designcode.patterncreate.builder.abstractClass.Packing;
import com.example.demo.designcode.patterncreate.builder.pack.Wrapper;

/**
 * 具体食品
 */
public class VegBurger extends Burger {

    @Override
    public float getPrice() {
        return 3737.5f;
    }

    @Override
    public String getName() {
        return "VerBurger";
    }
}
