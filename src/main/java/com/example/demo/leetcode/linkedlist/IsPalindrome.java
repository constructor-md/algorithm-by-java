package com.example.demo.leetcode.linkedlist;

/**
 * leetcode   判断回文链表
 * 给出头节点，判断是否为回文链表
 * 要求时间复杂度O(n)，空间复杂度O(1)
 * 指定复杂度，未指定遍历次数
 *
 * 一次遍历得到节点总数
 * 然后将链表从中间拆开，反转其中一部分，然后再次遍历两个链表，如果每次都相等则为回文
 * 链表拆开，没有增加空间
 * 遍历多次链表，没有嵌套等，仍可视为O(n)
 *
 * 经验总结：
 *  往往需要存储当前节点的前序节点
 *  回文可以拆一半反转比较、可以双指针逐一比较，可以放到栈中比较等思路，具体性能具体分析
 *
 *
 */
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {

        //空链表不可能回文
        if (head == null) {
            return false;
        }
        //单节点必回文
        if (head.next == null) {
            return true;
        }

        int count = 0;
        ListNode nowNode = head;
        //尾节点也计数
        while (nowNode != null) {
            count++;
            nowNode = nowNode.next;
        }

        //将前n/2个以外的部分分成新的链表
        ListNode tempHead = null;
        nowNode = head;
        for (int i = 1; i <= count / 2 - 1; i++) {
            //找到新链表的头节点的前一个节点
            nowNode = nowNode.next;
        }
        tempHead = nowNode.next;
        nowNode.next = null;


        if (count % 2 == 1) {
            //如果是奇数个节点，将前面n/2个节点取出作为一个新链表
            //剩下的作为另一个链表，并删除头节点，偶数则不删除
            tempHead = tempHead.next;
        }

        //反转tempHead
        //最开始的头节点
        ListNode oldHead = tempHead;
        //当前最新的头节点
        ListNode newHead = tempHead;

        //直到最开始的头节点变成尾节点
        while (oldHead.next != null) {
            ListNode change = oldHead.next;
            ListNode changeNext = change.next;
            oldHead.next = changeNext;
            change.next = newHead;
            newHead = change;
        }
        tempHead = newHead;

        //比较两个链表是否全等
        while (tempHead != null && head!= null) {
            if (tempHead.val != head.val) {
                return false;
            }
            tempHead = tempHead.next;
            head = head.next;
        }

        return true;
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(2, null);
        ListNode node4 = new ListNode(1, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(node1));
    }
}
