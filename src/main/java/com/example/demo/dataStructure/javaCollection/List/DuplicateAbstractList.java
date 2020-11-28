package com.example.demo.dataStructure.javaCollection.List;

import com.example.demo.dataStructure.javaCollection.DuplicateAbstractCollection;

/**
 * 该类提供了DuplicateList接口的框架实现，
 * 尽可能减少实现由“随机访问”数据存储（如数组）支持的接口所需的工作量。
 */
public abstract class DuplicateAbstractList<E> extends DuplicateAbstractCollection<E> {

    /**
     * 这个数字记录List在结构上被修改的次数
     * 结构修改指的是改变List大小的修改，或是 使正在进行的迭代产生不正确结果的干扰
     *
     * 如果这个值意外修改，迭代器将会报将抛出{@code ConcurrentModificationException}，
     * 以响应{@code next}、{@code remove}、{@code previous}、{@code set}或{@code add}操作。
     * 这提供了<i>fail-fast</i>，而不用面对在迭代过程中并发修改的非确定性行为。
     *
     *  子类使用这个字段是可选的。
     *  </b>如果子类希望提供快速失败的迭代器（和List迭代器），
     *  那么它只需在其{@code add（int，E）}和{@code remove（int）}方法
     *  （以及它重写的，任何导致列表的结构修改的其他方法）中增加该字段。
     *
     *  对{@code add（int，E）}或{@code remove（int）}的单个调用只能向该字段加一，
     *  否则迭代器（和列表迭代器）将抛出    伪造的{@code ConcurrentModificationExceptions} 并发修改异常。
     *  如果实现不希望提供快速失败迭代器，则可以忽略此字段。
     */
    protected transient int modCount = 0;


}
