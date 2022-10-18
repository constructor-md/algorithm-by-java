package com.example.demo.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146
 * <p>
 * 要求存取的时间复杂度为O(1)，采用Hash存储
 * 要求引入最近使用的变量，考虑使用链表维持顺序
 * 可能需要方便找到前驱和后驱，使用双向链表
 * get时，让指定节点放到链表最前面（所以提前记录链表的头尾节点地址方便操作）
 * put时，判断当前元素量，如果超过容量，就删除链表的尾节点，在头节点插入新数据
 * 实际上是使用链表的有序性，仅操作头尾来保证容量
 * 然后由利用Hash表的快速性，维持查找的速度
 * 利用记住头尾节点的方式，维持插入的速度
 *
 *
 * //教训、一定要把能封装的方法封装好，面向对象，节点的事情交给节点自己处理
 * 否则遇到长用例都不知道怎么查起，直接败北
 */
public class LRUCache1 {

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode nowHead;
    private DLinkedNode nowTail;
    //当前元素量
    private int count = 0;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            //把当前节点放最前面
            refresh(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        DLinkedNode node = new DLinkedNode(key, value);
        if (map.containsKey(node.key)) {
            map.get(node.key).val = node.val;
            refresh(map.get(node.key));
            return;
        }
        if (count == capacity) {
            if (capacity == 1) {
                map.remove(nowTail.key);
                nowHead = node;
                nowTail = node;
                node.head = node.tail = node;
            } else {
                node.head = nowTail;
                node.tail = nowHead;
                nowHead.head = node;
                nowTail.tail = node;
                nowHead = node;

                //删除尾节点
                nowTail.head.tail = nowHead;
                nowHead.head = nowTail.head;
                nowTail.head = nowTail.tail = null;
                map.remove(nowTail.key);
                nowTail = nowHead.head;
            }
            map.put(node.key, node);
            return;
        }

        //根据当前元素量，调整节点的位置
        if (count == 0) {
            nowHead = node;
            nowTail = node;
            node.head = node.tail = node;
        } else if (count == 1) {
            node.tail = node.head = nowHead;
            nowHead.head = nowHead.tail = node;
            nowTail = nowHead;
            nowHead = node;
        } else {
            node.head = nowTail;
            nowTail.tail = nowHead;
            node.tail = nowHead;
            nowHead.head = node;
            nowHead = node;
        }
        map.put(node.key, node);
        count++;

    }

    private void refresh(DLinkedNode node) {
        //当前节点放到头部
        if (map.containsKey(node.key) && node != nowHead) {
            if (count == 2) {
                //此时node是nowTail
                nowTail = nowHead;
                nowHead = node;
                return;
            }

            if (node == nowTail) {
                nowHead = node;
                nowTail = node.head;
            } else {

                DLinkedNode nodeHead = node.head;
                DLinkedNode nodeTail = node.tail;
                nodeHead.tail = nodeTail;
                nodeTail.head = nodeHead;

                node.head = nowTail;
                node.tail = nowHead;
                nowTail.tail = node;
                nowHead.head = node;
                nowHead = node;
            }

        }


    }

    private class DLinkedNode {

        private int key;
        private int val;
        private DLinkedNode head;
        private DLinkedNode tail;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }


    }

    public static void main(String[] args) {

        LRUCache1 lRUCache = new LRUCache1(10);
        lRUCache.put(10, 13);
        lRUCache.put(3, 17);
        lRUCache.put(6, 11);
        lRUCache.put(10, 5);
        lRUCache.put(9, 10);
        System.out.println(lRUCache.get(13));
        lRUCache.put(2, 19);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        lRUCache.put(5, 25);


    }

}
