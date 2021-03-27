package com.example.demo.designcode.patterncreate.builder;

import com.example.demo.designcode.patterncreate.builder.food.Coke;
import com.example.demo.designcode.patterncreate.builder.food.VegBurger;

/**
 * 套餐建造者
 * 负责具体创造一个meal对象
 *
 * 包含多个构建对象的方法，内部构建方式不同
 * 是个构建多种Meal对象的生产者
 *
 */
public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }


    public Meal prepareCokeMeal(){
        Meal meal = new Meal();
        meal.addItem(new Coke());
        return meal;
    }








}
