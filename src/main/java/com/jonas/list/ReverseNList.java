package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 反转前N个节点
 */
public class ReverseNList {

    private static ListNode successor = null;

    //反转以 head 为起点的 n 个节点，返回新的头结点
    public static ListNode reverseN(ListNode head, int n) {
        //base case : 反转一个元素，就是它本身，同时要记录后驱节点。
        if (1 == n) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverseN(head, 2);
        ListUtil.printList(newHead);
    }
}
