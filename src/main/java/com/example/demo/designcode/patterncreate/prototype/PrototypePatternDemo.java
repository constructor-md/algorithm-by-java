package com.example.demo.designcode.patterncreate.prototype;


import java.io.*;

/**
 * 原型模式
 * 创建型模式
 * 当直接创建对象的代价较大时，如对象需要在一个高代价的数据库操作后被创建
 * new 一个对象需要繁琐的数据准备或访问权限
 * 则采用缓存对象的方式，每次获取对象返回其克隆（一般都需要深拷贝，确保对象的内容可以任意修改）
 *
 * 浅拷贝将对象重新复制一份，包括内存空间新分配，变量值复制一份（如果变量也是对象，则其值其实仍为原对象的引用）
 *  浅拷贝的对象和元对象相同，只是地址不同，clone方法在进行上述操作后返回新的内存地址
 *  浅拷贝的变量仅拷贝了内存地址，指向同一个对象，如果在浅拷贝时进行了对象的变量值操作则会联动影响其他对象
 *  （基本类型不考虑，而String类由于String对象的不可变性，会在修改时生成新的String对象 不联动）
 *  注意（StringBuffer 则是可变字符串，该类没有实现clone接口，则修改会导致联动）
 *
 * 深拷贝则是将对象的依赖者全部拷贝一遍
 * 1. 简单一点的方法就是搞清楚被拷贝的对象的全部属性，为每一个拷贝重复对象重写clone方法，然后在clone方法中手动clone内部对象
 *      再设置进对象中，StringBuffer则需要重新新建StringBuffer对象，并获取老的值设置到新对象中
 *    //如果类层数很多，重写极为繁琐
 * 2.将每一个类实现{@link Serializable )接口，然后将类序列化为输出流，然后再从输入流读入转换（一般方法）
 *   如果类中有不能串行化的间接对象，或者含有循环结构，就会导致深拷贝困难，特别是重构老类时，可能遇见这种情况
 *
 *
 * 原型模式很少单独出现，一般在工厂方法中，将工厂的产品缓存起来，每次调用工厂方法返回对象的克隆
 *
 * 类的克隆需要实现Cloneable接口，是原型模式的约束。
 * 实现clone方法，调用父类的clone方法即可，当没有实现Cloneable接口而又调用了clone方法（Object的）
 * 会抛出{@link CloneNotSupportedException}
 *
 *
 *
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {

        //将对象加载到缓存hashTable中
        ShapeCache.loadCache();

        AbstractShape cloneShape = (AbstractShape) ShapeCache.getShape("1");
        System.out.println("Shape: " + cloneShape.getType());


    }

    //深拷贝流式示例
    //使用泛型使方法通用
    public static <T> T cloneTo(T src){

        T dist = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            //新建一个对象输出流，输出流实际上为ByteArrayOutputStream字节数组输出流
            //writeObject方法将对象写入输出流中
            // 写入过程中存在缓冲区，当对象序列化完毕就会停止写入，但是缓冲区可能仍有数据，需要flush方法将缓冲区数据强制输出完整
            out = new ObjectOutputStream(byteArrayOutputStream);
            out.writeObject(src);
            out.flush();
            //使用字节数组的内容新建字节输入流对象，将该对象的字节数组流重新反序列化为对象
            in = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            dist = (T) in.readObject();
        }catch (Exception e){
            throw new RuntimeException();
        } finally {
            //异常情况下，关闭流
            if (out != null){
                try {
                    in.close();
                    in = null;
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        return dist;
    }


}
