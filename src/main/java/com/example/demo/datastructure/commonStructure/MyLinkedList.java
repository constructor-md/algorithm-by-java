package com.example.demo.datastructure.commonStructure;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {

    //头指针
    private Node head;
    //当前总数
    private int count;

    public MyLinkedList() {

    }

    private static class Node {
        private int val;
        private Node next;

        private Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }
    
    public int get(int index) {
        if (index >= count) {
            return -1;
        }
        Node nowNode = head;
        //遍历到指定节点
        for (int i = 0; i < index; i++) {
            nowNode = nowNode.next;
        }
        return nowNode.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = null;
        if (head == null) {
            newNode = new Node(val, null);
        } else {
            newNode = new Node(val, head);
        }
        head = newNode;
        count++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node nowNode = head;
        //遍历到尾部节点
        for (int i = 1; i < count; i++) {
            nowNode = nowNode.next;
        }
        nowNode.next = new Node(val, null);
        count++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == count) {
            addAtTail(val);
            return;
        }
        if (index > count) {
            return;
        }
        Node nowNode = head;
        //遍历到指定index节点的前一个节点
        for (int i = 0; i < index - 1; i++) {
            nowNode = nowNode.next;
        }
        //在该节点后加入新节点
        nowNode.next = new Node(val, nowNode.next);
        count++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= count) {
            return;
        }
        //如果要求删除头节点
        if (index == 0) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
            count--;
            return;
        }
        Node nowNode = head;
        //遍历到指定index节点的前一个节点
        for (int i = 0; i < index - 1; i++) {
            nowNode = nowNode.next;
        }
        //删除下一个节点
        Node indexNode = nowNode.next;
        nowNode.next = indexNode.next;
        indexNode.next = null;
        count--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.get(0);
    }
}

