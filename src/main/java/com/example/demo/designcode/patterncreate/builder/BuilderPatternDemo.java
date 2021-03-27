package com.example.demo.designcode.patterncreate.builder;

/**
 * 建造者模式
 * 面临一个复杂对象的创建工作时，如复杂对象由各个部分的子对象用一定算法构成
 * 需求变化时，复杂对象的各个部分通常面临剧烈变化，但是组合复杂对象的算法相对稳定
 * （基本部件不变，但是组合经常变化）
 *
 * 关键：建造者：创建和提供实例  导演： 管理建造出的实例的依赖关系
 * 1. 肯德基的餐品不变，但是套餐内容变化
 * 2. StringBuffer对象  模拟实现：{@link }
 *
 * 建造出的产品之间必须有共同点，方便抽象
 * 如果内部变化会建立很多的建造类
 *
 * 使用场景：需要建立的对象具备复杂的内部结构，且内部属性相互依赖
 * 和工厂模式的差别在于，建造者模式关注的是零件的装配顺序
 * 工厂模式当然可以写构建对象的具体方法，但是如果方法变化，则需要修改生产线
 *
 *
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        vegMeal.getPrice();

        Meal cokeMeal = mealBuilder.prepareCokeMeal();
        cokeMeal.showItems();
        cokeMeal.getPrice();

    }








}
