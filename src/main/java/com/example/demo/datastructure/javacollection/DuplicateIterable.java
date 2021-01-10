package com.example.demo.datastructure.javacollection;

/**
 * 实现这个接口可以使对象可以使用for each的loop遍历语句
 */
public interface DuplicateIterable<T> {

    /**
     * 返回一个元素类型为 T 的迭代器
     */
    DuplicateIterable<T> duplicateIterable();



}
