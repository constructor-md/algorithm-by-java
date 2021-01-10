package com.example.demo.designcode.patterncreate.builder;

/**
 * 食品的抽象
 */
public interface Item {

    float getPrice();
    String getName();
    Packing getPacking();

}
