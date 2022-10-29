package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 237 删除链表节点
 *
 * 给定单链表和一个节点。不能访问head
 * 链表值均唯一，且保证给定节点node不是最后一个节点
 * 删除给定节点
 *
 * 单链表要删除一个节点必须知道上一个节点
 * 但本题链表值唯一，所以可以删除下一个节点，以下一个节点的值存在
 *
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
