package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 160  相交链表
 *
 * 给出两个无环链表的头节点，找到两个链表的相交节点，没有则返回null
 * 不能改变两个链表的结构
 *
 * 两个无环单链表如果相交，则交点后都是公共节点
 * 两个链表有长度差，但有公共尾部。
 * 从头遍历两个链表，让有长度差的先走长度差个节点
 * 然后两个链表同速，走到第一个节点相等处，即为链表的第一个交点
 * 遍历到尾节点，尾节点不相等则不相交
 *
 * 或根据路程相等原则
 * 当链表AC遍历完毕，再从B走到O
 * 同时出发的链表BC遍历完毕，也可从A走到O
 * 两个指针都正好遍历了所有节点
 * 过程中记下尾节点，如果尾节点不相等则不必继续循环，返回null
 *
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        //遍历所有节点
        ListNode a = headA;
        ListNode b = headB;
        ListNode aTail = null;
        ListNode bTail = null;

        while (a != b) {
            //判断尾节点是否相等
            if (a.next == null) {
                aTail = a;
            }
            if (b.next == null) {
                bTail = b;
            }
            if (aTail != null && bTail != null && aTail != bTail) {
                return null;
            }
            //尾节点如果可以相等，则相同路程必然能走到节点相同出，自然退出循环
            //a遍历到尾部，则从b继续遍历
            if (a.next == null) {
                a = headB;
            } else {
                a = a.next;
            }
            //b遍历到尾部，则从a继续遍历
            if (b.next == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
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
