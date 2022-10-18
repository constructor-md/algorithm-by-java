package com.example.demo.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode nowHead;
    //当前元素量
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        //初始化伪头节点
        nowHead = new DLinkedNode();
        nowHead.tail = nowHead.head = nowHead;
        //头节点不会被访问到数据，用于保证链表不为空
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.remove();
            //由于有头节点的存在，不用担心删除掉自己，于是可以直接插入到头节点之后，作为数据的最前
            nowHead.insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {

        DLinkedNode node = map.get(key);
        if (node == null) {
            //不存在就创建一个节点
            node = new DLinkedNode(key, value);
            //不存在，写入Map，并放在Head之后
            map.put(key, node);
            count++;
            //此处可能超过容量
            nowHead.insert(node);
        } else {
            //存在，从链表中删除，并更新值
            //从链表删除后再插入到Head之后
            node = node.remove();
            node.val = value;
            nowHead.insert(node);
        }

        //处理容量超出,删除末尾元素
        if (count > capacity) {
            //由于第一个插入，使得链表成环了，后续链表也维持环形，于是可以直接从Head获取Tail
            DLinkedNode removed = nowHead.head.remove();
            //删除后返回自身的方法非常重要，因为可能会删除自己还是用到自己
            map.remove(removed.key);
            count--;
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

        //在链表中删除自己，拼接前后，并返回被删除的元素，不让其随便消失
        public DLinkedNode remove() {
            head.tail = tail;
            tail.head = head;
            head = tail = null;
            return this;
        }

        //将节点插入到自己后面，因为思路上让所有的数据都在Head之后，头节点永远不变，保持链表不为空，避免极端情况
        public void insert(DLinkedNode node) {
            tail.head = node;
            node.head = this;
            node.tail = tail;
            tail = node;
        }


    }

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));
//        lRUCache.put(2, 2);
//        System.out.println(lRUCache.get(1));
//        lRUCache.put(3, 3);
//
//        lRUCache.put(4, 4);
//        System.out.println(lRUCache.get(1));
//        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));



    }

}
