package com.example.demo.designcode.patternstructure.flyweight;

/**
 * 享元模式
 * 行为型模式
 * <p>
 * 即对象共享
 * 减少对象的创建次数，当对象需要重复创建，且只需要单一结果的情况下使用
 * 大量对象可能造成内存溢出，共享对象，在相同请求情况下直接返回已有对象
 * <p>
 * 关键：使用hashMao存储，工厂对象控制
 * <p>
 * 减少对象创建，降低内存
 * <p>
 * 使用场景：
 * 系统有大量相似对象
 * 需要缓冲池
 * <p>
 * 由于可能存在多个任务请求对象，需要注意线程安全问题
 */
public class FlyweightPatternDemo {

    private static final String colors[] =
            {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        /**
         * 创建了多个圆，但是每个圆的生命周期只有一个循环，不必每次都创建
         * 所以可以用享元模式工厂创建
         */
        for (int i = 0; i < 20; ++i) {
            Circle circle =
                    (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    //根据颜色值获取随机颜色
    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
