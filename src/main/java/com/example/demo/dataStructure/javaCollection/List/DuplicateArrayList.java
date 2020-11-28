package com.example.demo.dataStructure.javaCollection.List;

import com.example.demo.dataStructure.javaCollection.DuplicateCollection;
import com.example.demo.dataStructure.javaCollection.DuplicateIterable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * 重写ArrayList的实现
 */
public class DuplicateArrayList<E> extends DuplicateAbstractList<E> implements Serializable , DuplicateCollection<E> {

    /**
     * Java序列化机制通过判断serialVersionUID验证版本一致性
     * 反序列化时，对字节流中的serialVersionUID和本地相应实体类的serialVersionUID比较，相同则说明时一致，可以进行反序列化
     * 否则报InvalidCastException，反序列化版本不一致的异常
     * 如果不写，JAVA序列化机制会根据Class自动生成一个serialVersionUID作序列化版本比较用，
     * 如果Class文件(类名，方法明等)没有发生变化(增加空格，换行，增加注释等等)，就算再编译多次，serialVersionUID也不会变化的。
     * 序列化操作：
     *
     */
//    private static final long serialVersionUID = 23904737487441L;

    /**
     * 数组默认的初始容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 分享空数组实例时使用的空数组实例
     * todo 备看 https://blog.csdn.net/vansbelove/article/details/72628879
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};


    /**
     * 分享空数组实例使用的默认大小实例，和空的元素数据区分开
     * 帮助了解添加第一个元素时数组要膨胀多少
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 存储ArrayList数组元素的数组缓冲区
     * ArrayList的容量就是这个数组缓冲区的长度
     * 任何一个空的ArrayList（elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA）
     * 会在添加一个元素时将容量扩展到DEFAULT_CAPACITY
     *
     * 此处transient修饰的变量不会被序列化，生命周期只在操作者内存中，而不到网络传输或写入磁盘
     */
    transient Object[] elementData;

    /**
     * ArrayList的大小，是实际包含的元素个数，而非数组长度
     */
    private int size;


    /**
     * 构造具有指定初始容量的ArrayList
     */
    public DuplicateArrayList(int initialCapacity){
        //根据输入容量构造指定大小的数组
        //如果小于0，抛出非法参数异常
        if (initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * 构造一个包含指定元素的特殊数组，其顺序由集合的迭代器返回
     *
     */
    public DuplicateArrayList(DuplicateCollection<? extends E> c){
        //将传入的集合类元素转为数组
        //如果长度不为0，判断如果传入集合类实例为DuplicateArrayList，则直接将数组赋给本对象
        //如果实例不是，则使用Arrays的copyOf方法，将指定集合信息传入返回对象数组
        Object[] a = c.toArray();
        if ((size = a.length) != 0){
            if (c.getClass() == DuplicateArrayList.class){
                elementData = a;
            }else {
                elementData = Arrays.copyOf(a,size,Object[].class);
            }
        }else {
            //为0则赋值为空数组
            elementData = EMPTY_ELEMENTDATA;
        }

    }

    /**
     * 将数组容量调整为数组的当前大小
     * 应用程序可以使用该操作来最小化数组实例的存储，去除元素为空的部分
     * 大小是否小于元素个数，如果小，则判断实际元素个数是否为0，0则赋给空数组
     * 非0，则将集合用copyOf方法，生成指定大小的数组，放置当前元素
     */
    public void trimToSize(){
        //修改了集合结构，使modCount++
        modCount++;
        if (size < elementData.length){
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData,size);
        }
    }

    /**
     * 如果有必要，增加ArrayList的容量，使得它可以容纳
     * minimum capacity 参数指定的元素个数
     * minCapacity 就是期望的 minimum capacity
     * ensure:确保
     *
     * 如果预知需要增大多少容量，直接使用这个方法扩容
     *
     * 扩展：redis的动态字符串也是通过预分配冗余空间的形式减少内存的频繁分配，但是扩容策略有差异
     * redis动态字符串扩容策略：当前字符串分配的实际空间一般高于实际字符串长度。
     * 当字符串长度小于1MB，扩容都是加倍现有的空间
     * 当字符串长度超过1MB，每次只扩容1MB  --字符串最大长度为512MB
     * 两者的使用场景导致了这种设计差别：
     * ArrayList：通常用于某个函数，生命周期很短，出栈后就可以回收
     * Redis：通常用作缓存，失效时间相对较长：几秒，几分钟，几小时等
     * Redis的最大值限制：因为通常和使用者不在同一个服务器上，需要通过网络传输，如果很大，传输容易超时
     * 且redis主任务为单线程，容易阻塞其他任务的执行
     *
     */
    public void ensureCapacity(int miniCapacity){
        //如果集合不是空，则最小展开值为0 如果不是空 则最小展开值为默认容量10
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                ? 0 :DEFAULT_CAPACITY;

        //如果输入的指定容量大于最小容量，则执行方法
        if (miniCapacity > minExpand){
            ensureExplicitCapacity(miniCapacity);
        }
    }
    //Explicit 明确的
    private void ensureExplicitCapacity(int minCapacity){
        modCount++;

        //溢出感知代码，理解为溢出会被感知，不会导致错误的行为
        //如果输入的指定容量大于数组长度，则执行方法增长数组
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 要分配的数组最大大小
     * 因为有些JVM会保留一些头部信息（如数组长度）在数组对象中 即为了存储这些头信息，需要占用 存储8 左右的元素尺寸大小，-8这个范围减少了
     * 如果尝试分配过大的可能会导致JVM报OutOfMemoryError：请求的数组大小超过虚拟机限制
     *
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    /**
     * 增加容量，确保可以容纳指定的元素数
     * 不一次加1的形式扩大容量，目的是空间换时间，一次增加合适容量供给后续使用
     */
    public void grow(int minCapacity){


        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        //新的容量设为老容量的1.5倍

        //如果新容量小于老容量，则容量不变 -如果oldCapacity 十分接近Integer.MAX_VALUE，
        //运算oldCapacity + (oldCapacity >> 1)值为负数，因为加法上溢了，此处感知这种溢出
        //注意：如果使用 a<b 的方式比较，则负数必然小于传入的值。而实际上它只是一个大数，这与期望相反
        //而如果做减法，则有希望二进制减回来，调用该方法的入参和新容量值之间一般差距不大，可以减回来
        //如果减不回来，判断仍为负数，则新容量值过大，设置为指定可满足最小容量即可
        //https://zhuanlan.zhihu.com/p/100590364
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //新容量值和最大数组容量Integer.MAX_VALUE - 8值进行比较。如果更大，超出最大容量值
        //执行huge方法
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        //miniCapacity 通常接近size，所以以下是可行的
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        //如果指定容量小于0，说明溢出，直接抛出错误，超出虚拟机允许范围
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        //如果指定容量为正数，未超出虚拟机允许范围，则判断是否超出类定义的最大数组范围
        //进入这个方法已经说明，欲扩容容量大于数组最大容量值（不可使用）（非最小满足数组存储需求的容量minCapacity），判断最小满足容量决定扩容容量
        //如果此处判断最小满足容量未溢出且大于最大容量，说明在Integer.MAX_VALUE和 ~ -8之间
        //即超出了最大容量限制，则设置值为Integer.MAX_VALUE，就算超出了也会设置容量，且不是-8 的，此处部分虚拟机会报错，没惯着
        // 如果没有超出，扩容容量设置为MAX_ARRAY_SIZE
        //所以实际上最大容量ArrayList的最大容量是Integer.MAX_VALUE，数组的最大容量限制只是尽量满足一些虚拟机的需求
        //https://blog.csdn.net/w605283073/article/details/109696771
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 计算容量
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity){
        //如果原数组为空，则将大小限制为默认容量和传入期望容量的最大值--性能优化
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        return minCapacity;

    }

    /**
     * 确认容量内部--不明作用
     */
    private void ensureCapacityInternal(int minCapacity){
        ensureExplicitCapacity(calculateCapacity(elementData,minCapacity));
    }

    /**
     * 备看
     * ArrayList内部有一个私有类实现Iterator接口，因此可以使用iterator()方法得到ArrayList的迭代器，
     * 同时，还有一个私有类实现了ListIterator接口，因此ArrayList也可以调用listIterator()方法得到ListIterator迭代器
     * 由于ArrayList的所有方法都是默认在单一线程下进行的，因此ArrayList不具有线程安全性。
     * 若想在多线程下使用，应该使用Colletions类中的静态方法synchronizedList()对ArrayList进行调用即可
     *
     *
     * 扩展：ArrayList和LinkedList的区别
     * 除了由于数组和链表的存储结构带来的查找和插入差异之外的性能差别
     * 两者哪个更占空间？
     * LinkedList占用空间主要体现在每个Node要保存前后指向地址的节点，数据量大时占用内存比例较大
     * ArrayList会在添加元素时扩容为1.5倍，如果只插入一个元素，扩容的空间浪费不少，且基础空间越大越是如此
     * 但是，ArrayList有个transient变量，使得elementData这个存放数组元素的空间不被序列化
     * 因为序列化ArrayList的时候，数组即elementData未必是满的，没必要序列化整个elementData
     * 所以ArrayList中重写了writeObject方法，每次序列化的时候调用这个方法，
     * 先调用defaultWriteObject()方法，序列化非transient元素，而elementData不序列化
     * 而只是遍历elementData，只序列化数组中有数据的元素，这样一来，加快了序列化的速度，减少的空间的开销
     * 注意：序列化操作在写入文件和网络传输这些时候发生，如果放入了null元素，在数组中会占用位置（某次业务开发经验报错）
     *
     * 面试回答：
     * 一般情况下，LinkedList的占用空间更大，因为每个节点要维护指向前后地址的两个节点，
     * 但也不是绝对，如果刚好数据量超过ArrayList默认的临时值时，ArrayList占用的空间也是不小的，
     * 因为扩容的原因会浪费将近原来数组一半的容量，不过，因为ArrayList的数组变量是用transient关键字修饰的，
     * 如果集合本身需要做序列化操作的话，ArrayList这部分多余的空间不会被序列化。
     * https://www.cnblogs.com/yeya/p/13430797.html
     */











    //implement


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public DuplicateIterable<E> duplicateIterable() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
