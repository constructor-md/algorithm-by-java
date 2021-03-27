package com.example.demo.designcode.patterncreate.builder.pack;

import com.example.demo.designcode.patterncreate.builder.abstractClass.Packing;

/**
 * 具体包装类
 */
public class Bottle implements Packing {


    @Override
    public String pack() {
        return "Bottle";
    }
}
