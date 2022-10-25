package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 203 移除链表元素
 * 给定val值，移除所有满足val的链表元素
 *
 * 练习链表元素的移除操作
 *
 * 由于移除链表的元素，每次都需要知道前一个节点
 * 干脆设置虚头节点，每每涉及到移除单链表的节点，都可以考虑设置虚头节点，用于顺畅头节点的删除
 * 每次均删除下一个节点
 *
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        if(head == null) {
            return null;
        }
        ListNode preNode = new ListNode();
        preNode.next = head;
        //每次均删除下一个节点
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                //如果被删除的是头节点，则改变头节点
                if (preNode.next == head) {
                    head = preNode.next.next;
                }
                preNode.next = preNode.next.next;
                //删除后，preNode不移动
            } else {
                //不需要删除，则移动
                preNode = preNode.next;
            }
        }
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
