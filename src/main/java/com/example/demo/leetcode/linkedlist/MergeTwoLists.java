package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 21 合并两个有序链表
 *
 * 将两个升序链表合并成一个升序链表并返回，新链表拼接两个链表的所有节点组成
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode nowNode = head;
        while (list1 != null && list2 != null) {
            ListNode temp = null;
            //先把小的接到新链表中
            if (list1.val < list2.val) {
                nowNode.next = list1;
                temp = list1.next;
                list1.next = null;
                list1 = temp;
            } else if (list1.val > list2.val) {
                nowNode.next = list2;
                temp = list2.next;
                list2.next = null;
                list2 = temp;
            } else if (list1.val == list2.val){
                nowNode.next = list1;
                temp = list1.next;
                list1.next = null;
                list1 = temp;

                nowNode = nowNode.next;

                nowNode.next = list2;
                temp = list2.next;
                list2.next = null;
                list2 = temp;
            }
            nowNode = nowNode.next;
        }

        if (list1 == null) {
            //接入list2剩下的内容
            nowNode.next = list2;
        }
        if (list2 == null) {
            //接入list1剩下的内容
            nowNode.next = list1;
        }
        return head.next;
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
