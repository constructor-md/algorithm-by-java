package com.example.demo.designcode.patterncreate.builder;

import com.example.demo.designcode.patterncreate.builder.abstractClass.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐类
 * 变量中带有基本内容的集合 和操作集合的方法 以及输出具体属性内容的方法
 * 都是符合套餐概念的单一职责内容
 * 等待套餐建造者类创建套餐对象
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

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.getName());
            System.out.print(", Packing : "+item.getPacking().pack());
            System.out.println(", Price : "+item.getPrice());
        }
    }

}
