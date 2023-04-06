package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 删除链表的倒数第 N 个结点 (leetcode: 19)
 */
public class RemoveKthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点,防止出现空指针的情况
        // 比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，
        // 那按照算法逻辑，应该首先找到倒数第 6 个节点。但第一个节点前面已经没有节点了，这就会出错。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = FindKthFromEnd.findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildRandomList(6);
        ListUtil.printList(head);
        head = removeNthFromEnd(head, 6);
        ListUtil.printList(head);
    }
}
