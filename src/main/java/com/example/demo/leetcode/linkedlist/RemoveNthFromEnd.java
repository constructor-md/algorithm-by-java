package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 19 删除单链表的倒数第N个节点
 *
 * n不会越界
 * 要求用一次扫描实现
 *
 * 如果是两次扫描，则容易得到链表长度，进而在第二次扫描做到
 * 现在知道了n，也就是知道了到底倒数第几
 * 使用快慢指针，快指针先于慢指针走n步，则快指针到达尾节点时，慢指针删除所在节点
 *
 *
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode removePre = null;
        //fast先走n - 1位，slow成为fast倒数n个（数自己）
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }

        //两者同时前进，直到fast到达尾部
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                //如果fast到达尾部，则记录下slow的前一个节点，方便删除
                removePre = slow;
            }
            slow = slow.next;
        }
        //可能n = 1，len = 1，fast = slow = head removePre = null
        //可能fast.next = null，但是slow = head removePre = null
        //直接判断pre的状态，如果为null，则删除头节点即可

        //删除slow
        if (removePre == null) {
            head = head.next;
        } else {
            removePre.next = slow.next;
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
