package com.example.demo.dataStructure.javaCollection.List;


/**
 * 这个类包含了多种操作（manipulating）数组的方法（如排序和查找）
 * 这个类也包含了一些静态工厂，使得数组可以被作为List访问
 *
 * 如果指定的数组引用为null，除非有特殊说明，否则都将抛出NullPointException空指针异常
 *
 * 类中的方法注释包括实现的简要说明，这些描述应该被视为实施说明，而不是规范
 * 只要遵守规范本身，实现者应该可以替换其他算法
 *
 * 例如{@code-sort（Object[]）}使用的算法不一定是MergeSort，但它必须是<i>稳定的</i>）
 *
 * 是Java集合框架的一员
 *
 */
public class DuplicateArrays {

    /**
     *
     * 最小数组长度，低于这个长度的话，并行排序算法不会进一步划分排序任务
     * 如果使用较小的大小，将会导致内存争用，使得并行加速变得不太可能
     */
    private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;

    //抵制默认构造函数，确保这个类不会被实例化
    private DuplicateArrays(){};




}
