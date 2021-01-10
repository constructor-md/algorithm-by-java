package com.example.demo.datastructure.javacollection;


/**
 *
 * 常用的一些接口Callable、Runnable、Comparator等在JDK8中都添加了@FunctionalInterface注解。
 *
 * 1、该注解只能标记在"有且仅有一个抽象方法"的接口上。
 * 2、JDK8接口中的静态方法和默认方法，都不算是抽象方法。
 * 3、接口默认继承java.lang.Object，所以如果接口显示声明覆盖了Object中方法，那么也不算抽象方法。
 * 4、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。
 * 如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。
 *
 * 函数式接口指的是有且仅有一个抽象方法的接口，如果接口中包含不止一个抽象方法，则编译报错
 *
 *
 */
@FunctionalInterface
public interface DuplicateComparator<T> {


    /**
     *
     *
     *
     */
    int compare(T o1, T o2);

}
