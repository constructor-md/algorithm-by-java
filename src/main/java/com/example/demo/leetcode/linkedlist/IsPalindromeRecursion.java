package com.example.demo.leetcode.linkedlist;

/**
 * 可以通过递归法将单链表从后往前遍历
 * 但是递归法不能满足O(1)空间复杂度
 * 除了链表自身空间外，还有同等的栈深度 相当于O(n)
 * 可以通过栈的后进先出，将链表值进行存储，即替代反转链表，但是不如反转链表的O(1)空间复杂度，时间复杂度区别又不大
 *
 *
 */
public class IsPalindromeRecursion {

    public static boolean isPalindrome(IsPalindrome.ListNode head) {

        //空链表不可能回文
        if (head == null) {
            return false;
        }
        //单节点必回文
        if (head.next == null) {
            return true;
        }


        return true;
    }

    //灵感：如果对链表逆序打印可以通过迭代实现，最先被执行的是最后一个迭代内容
    private void printListNode(ListNode head) {
        if (head == null)
            return;
        printListNode(head.next);
        System.out.println(head.val);
    }

    //下述为递归打印链表的灵感做出的代码
    ListNode temp;
    public boolean isPalindrome(ListNode head) {
        //记住头节点
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null)
            return true;
        //一直到尾节点才会触发比较，首次进行比较的是头节点和尾节点
        boolean res = check(head.next) && (temp.val == head.val);
        //头部变成下一个节点
        temp = temp.next;
        //递归退出使得尾部变成下一个节点 成为新的比较基础  妙处一在于利用递归反向遍历了链表，二是让正序值缓存在外，随着递归的进行不断进位，使得相当于双指针不断比较
        return res;
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
