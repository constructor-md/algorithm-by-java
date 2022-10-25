package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 206  反转链表
 * 返回反转后的链表的头节点
 *
 * 记住最开始的头节点和最新的头节点
 * 不断将最开始的头节点的后一个节点移动到最左边作为新的头节点，最终链表就被反转
 *
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        //最开始的头节点
        ListNode oldHead = head;
        //当前最新的头节点
        ListNode newHead = head;

        //直到最开始的头节点变成尾节点
        while (oldHead.next != null) {
            ListNode change = oldHead.next;
            ListNode changeNext = change.next;
            oldHead.next = changeNext;
            change.next = newHead;
            newHead = change;
        }
        return newHead;
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
