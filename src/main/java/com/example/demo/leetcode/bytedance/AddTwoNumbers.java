package com.example.demo.leetcode.bytedance;

import java.util.List;

/**
 * leetcode 2
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //结果的头结点
        ListNode result = null;

        //从输入的次节点开始
        ListNode node1 = l1;
        ListNode node2 = l2;
        //结果的当前节点
        ListNode node3 = null;
        int carry = 0;
        while(node1 != null || node2 != null) {
            ListNode node = null;
            if (node1 != null && node2 != null) {
                int val = node1 .val + node2.val + carry;
                if (val > 9) {
                    val = val % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                node = new ListNode(val, null);
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1 == null && node2 != null) {
                int val = node2.val + carry;
                if (val > 9) {
                    val = val % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                node = new ListNode(val, null);
                node2 = node2.next;
            } else if (node1 != null && node2 == null) {
                int val = node1.val + carry;
                if (val > 9) {
                    val = val % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                node1 = node1.next;
                node = new ListNode(val, null);
            }

            //将结果节点接上链表
            if (node3 == null) {
                //建立第一个节点
                node3 = node;
                result = node;
            } else {
                //让当前节点与结果节点连接
                node3.next = node;
                //让结果节点作为当前节点
                node3 = node;
            }
        }
        //最后，如果计算结果末尾有进位，建立末尾节点
        if (carry == 1) {
            ListNode tailNode = new ListNode(carry, null);
            node3.next = tailNode;
        }
        return result;
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
