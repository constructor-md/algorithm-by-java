package com.example.demo.designcode.patterncreate.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 */
public class Meal {

    private List<Item> items = new ArrayList<>();
    private String name;
    private float price;

    public void addItem(Item item){
        items.add(item);
    }

    public float getPrice(){
        for (Item item : items){
            price += item.getPrice();
        }
        return price;
    }

}
