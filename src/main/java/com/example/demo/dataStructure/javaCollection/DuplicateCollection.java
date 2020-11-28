package com.example.demo.dataStructure.javaCollection;


/**
 * 集合结构中的根接口
 * @param <E>
 * @see     Set
 * @see     List
 * @see     Map
 * @see     SortedSet
 * @see     SortedMap
 * @see     HashSet
 * @see     TreeSet
 * @see     ArrayList
 * @see     LinkedList
 * @see     Vector
 * @see     Collections
 * @see     Arrays
 * @see     AbstractCollection
 */
public interface DuplicateCollection<E> extends DuplicateIterable<E>{


    /**
     * 返回集合中元素的数量，如果集合包含超过Integer.MAX_VALUE的元素
     * 返回Integer.MAX_VALUE
     */
    int size();

    /**
     * 在集合没有元素时返回true
     */
    boolean isEmpty();

    /**
     * 在集合包含指定元素时返回true
     * 更正式的说，当且仅当集合包含至少一个指定元素时返回true
     *
     */
    boolean contains();

    /**
     * 返回一个该集合元素的迭代器
     * 但是没有提供元素顺序的保证，除非这个集合是实现了保证的类的实例
     */
    DuplicateIterable<E> duplicateIterable();

    /**
     * 返回一个包含该集合所有元素的数组
     * 如果集合对迭代器返回元素的顺序具备任何保证，则该方法必须以相同顺序返回元素
     *
     * 该方法返回的数组应该是“安全的”，因为这个集合不维护这个数组的实例
     * 即 该方法必须返回一个新数组，调用者可以自由修改返回的数组
     *
     * 该方法充当了基于数组和基于集合的API之间的桥梁
     *
     */
    Object[] toArray();


}
