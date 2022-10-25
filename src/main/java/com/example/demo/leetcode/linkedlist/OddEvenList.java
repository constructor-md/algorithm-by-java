package com.example.demo.leetcode.linkedlist;

/**
 * leetcode 328  奇偶链表
 *
 * 将初始链表中，奇偶索引 的节点分组，并保持原来的前后顺序排列在原始链表中
 * 即原来是奇数索引的全部按顺序往后排，偶数索引的按顺序往前排
 * 要求时间复杂度O(N)，空间复杂度O(1)
 *
 * 直接新建一个头节点，把奇数索引的全部取出，然后将两组拼接
 *
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {

        //从有三个节点的链表开始操作，排除掉只有两个以下节点的情况
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //偶数节点组
        ListNode tempHead = new ListNode();
        //从有三个节点的链表开始考虑，从第二个节点开始遍历，该节点始终在head所在链表上，head节点作为奇数节点组
        ListNode nowNode = head.next;
        //tempHead所在链表的末尾
        ListNode tempTailNode = tempHead;

        //需要被删除的节点的前节点
        ListNode removePre = head;

        int num = 2;
        //尾节点进入循环
        while (nowNode != null) {
            if (num % 2 == 0) {
                //记下被删除者的下一个
                ListNode removeNext = nowNode.next;
                //把下一个和上一个拼起来完成删除
                removePre.next = removeNext;

                //将被删除者放到奇数组的末尾
                tempTailNode.next = nowNode;
                tempTailNode = tempTailNode.next;
                nowNode.next = null;

                //更新当前节点为原节点的下一个
                nowNode = removeNext;
                //当前节点指针相当于移动到了下一个，需要改变当前索引值
                num++;
                //删除了原节点，但是原节点的前序节点仍是新节点的前序节点，前序节点不变
            } else {
                //如果不需要删除，则当前节点后移
                nowNode = nowNode.next;
                //变更当前索引
                num++;
                //前序节点后移
                removePre = removePre.next;
            }
        }

        //将tempHead的后面，拼接到nowNode的后面
        //由于尾节点进入循环，所以，如果尾节点为偶数索引，则当前尾节点值为空，前序节点才是尾节点
        //                          如果尾节点为奇数索引，则尾节点就是尾节点，但是尾节点后移为空，前序节点才是尾节点
        removePre.next = tempHead.next;
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
