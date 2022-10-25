package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 141 环形链表
 *
 *
 * 双指针判断链表中是否有环
 *  如果没有环，fast将首先到达终点(尾节点next为null)
 *  如果有环，则两者最终将相遇
 *
 * 注意操作链表节点前，一定要避免该节点为空
 *
 *
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            } else {
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
            }
            if (fast == slow) {
                return true;
            }
        }
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
