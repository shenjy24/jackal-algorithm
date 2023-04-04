package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 单链表的中点 (leetcode:876)
 */
public class MiddleNode {

    /**
     * 如果结点数为偶数，则取中间两个结点的前面一个
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 如果结点数为偶数，则取中间两个结点的后面一个
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildRandomList(5);
        ListUtil.printList(head);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }
}
