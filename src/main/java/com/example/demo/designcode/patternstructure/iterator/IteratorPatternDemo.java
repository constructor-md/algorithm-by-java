package com.example.demo.designcode.patternstructure.iterator;

/**
 * 迭代器模式
 *
 * 方便顺序访问集合中的元素而不必知道集合的具体实现
 *
 * 关键代码：hasNext、next接口
 * 可以通过不同的方法遍历一个聚对象
 *
 * 优点：
 *
 * 将元素中游走的责任交给聚合迭代器实现，而非聚合对象（遍历方式不固化，可被插入拓展）
 * 可以使一个聚合有多种遍历方式
 * 增加新的聚合类和迭代器类都很方便，不需要修改原有内容
 *
 * 缺点：将存储数据和遍历数据的职责分离，增加新的聚合类需要对应的迭代器，一定程度上增加了系统复杂性
 *
 * 实例：java集合均继承了Iterator接口，实现了迭代器功能，在foreach增强循环语句中底层使用迭代器实现
 *
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }




}
