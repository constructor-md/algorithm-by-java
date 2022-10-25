package com.example.demo.leetcode.linkedlist;

/**
 *
 * leetcode 142 环形链表Ⅱ
 *
 * 给出链表的头节点，返回链表开始入环的节点
 * 无环则返回null，不允许修改链表
 *
 * 假设出发起点到环起点的距离为m，环周长为n
 * 第一次相遇点距离环起点距离为k
 * 则相遇时：
 *  慢指针的移动距离为 i = m + a*n + k
 *  快指针的移动距离为 2i = m + b*n + k
 *  a、b为相遇前走过环的圈数
 *  则i为(b - a) * n 即环长的倍数
 *
 * 让其中一个节点回到头节点，另一个留在相遇点
 * 两者同以1速移动，当再次相遇时
 *  从头开始的节点移动了m
 *  环中节点则共移动了i+m
 *  可以理解为，环中节点是从链表起点移动到了环起点，再转了几圈
 *  所以相遇点即为环起点
 *
 *
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
                if (fast == null) {
                    return null;
                }
            }
            if (fast == slow) {
                //找到起点
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
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
