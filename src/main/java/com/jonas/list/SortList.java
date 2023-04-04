package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 链表排序: 以下使用的是归并排序 (二叉树的后序遍历)
 */
public class SortList {

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sort(mid.next);
        mid.next = null;
        ListNode left = sort(head);
        return MergeTwoList.merge(left, right);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildRandomList(7);
        ListUtil.printList(head);
        ListUtil.printList(sort(head));
    }
}
