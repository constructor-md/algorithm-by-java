package com.example.demo.datastructure.javacollection.List;


import com.example.demo.datastructure.javacollection.DuplicateComparable;
import com.example.demo.datastructure.javacollection.DuplicateComparator;

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


    /**
     * 一种比较器，实现一组相互比较的元素的自然排序
     * 可以在提供的比较器为空的时候使用
     * 为了简化底层的代码复用，compare方法只为其第二个参数声明类型对象
     *
     * Arrays实现者注：
     * 可比较的TimSort（一个归并排序做了大量优化的版本）的性能是否与此Comparator提供的TimSort有任何性能优势
     * 这是一个经验问题。否则，最好删除或绕过Comparable TimSort。
     * 目前还没有将它们分离用于并行排序的经验案例，因此所有公共对象归并排序方法都使用相同的基于Comparator的实现。
     */
    static final class NatureOrder implements DuplicateComparator<Object> {
        //告知编译器忽略指定的警告，不必在编译完成后出现警告信息
        //可以标注在类、字段、方法、参数、构造方法，以及局部变量上。
        @SuppressWarnings("unchecked")
        public int compare(Object first,Object second){
            return ((DuplicateComparable<Object>)first).compareTo(second);
        }

        static final NatureOrder INSTANCE = new NatureOrder();
    }




}
