package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 反转链表 [m, n] 范围内的结点
 */
public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // base case : 相当于反转前 n 个元素
        if (1 == m) {
            return ReverseNList.reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverseBetween(head, 2, 4);
        ListUtil.printList(newHead);
    }
}
