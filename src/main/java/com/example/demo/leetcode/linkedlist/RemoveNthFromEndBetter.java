package com.example.demo.leetcode.linkedlist;

/**
 * 当间隔为n时，慢指针为倒数第n+1个
 * 干脆设虚拟头节点为出发点，每次删除均删除下一个，使得头节点例外情况被避免
 *
 * 链表的总结：
 *  调用next时，始终判断是否为空
 *  仔细定义循环的结束条件
 *
 * 双指针的思考角度：
 *  双指针的移动方向是同向还是对向
 *  双指针的移动速度是每次1步还是几步
 *  双指针的起始移动需要间隔吗，间隔多少
 *
 */
public class RemoveNthFromEndBetter {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //虚拟头节点
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        //fast先走n位，slow是倒数第n+1个
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //两者同时前进，直到fast到达尾部,slow到达n+1
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //fast所在位置为尾节点，slow所在位置为n+1
        slow.next = slow.next.next;
        return preHead.next;
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
