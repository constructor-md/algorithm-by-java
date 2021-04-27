package com.example.demo.designcode.patternstructure.bridge;

/**
 * 桥接模式
 * 结构性模式
 *
 * 实体类和接口实现类两者之间可以各自结构化改变而互不影响
 *
 * 关键代码：抽象类依赖实现类
 *
 *
 * 本质上将抽象和实现 之间的关系由继承变成关联、并列，使两者可以独立变化，不必因为一方变化影响另一方
 * 即使用对象之间组合（shape中维护drawApi）解锁原本依赖和实现之间的耦合关系
 *
 *
 * 在实际中可能遇见的情况：如系统可能进行多个维度的变化，但是维度之间相互依赖
 * 各个维度各自抽象，然后各自实现，最终在抽象类中组合
 *
 * 各个维度的关系在抽象类之中耦合，各个维度的抽象各自去发展实现，最终在抽象类中组合实现系统
 *
 * 缺点：各维度抽象之间的聚合关联关系建立在抽象层，需要对抽象进行编程，并增加了系统的复杂性
 *
 * 优点：各维度解耦合，实现关系清晰，易拓展
 *
 * 实例：JDK中的JDBC
 *
 * 对各个不同的数据库，JDK提供统一的Driver 接口 供给各个厂商实现，driver的静态方法将一个Driver对象注册到 DriverManager
 * DriverManager提供了getConnection方法，其中Connection使Java提供给各个数据库的相同操作 接口，各个数据库独立实现各自的Connection接口实现
 *
 * 即Connection数据库操作方法和Driver驱动各自变化，最终使用了DriverManager类进行桥接，聚合两者，使平行的两者通过Manager组合工作
 *
 * 如果因为转账动作有很多种，转帐用户也分很多种，而将（使用转账动作的用户）作为抽象的话，将导致实现类爆炸，分开发展显然更加清晰，也更少，将继承的以来变成了并行的组合
 *
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }


}
