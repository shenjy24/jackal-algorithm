package com.jonas.list;

import com.jonas.util.ListNode;

/**
 * 删除排序链表中的重复元素 (leetcode: 83)
 */
public class RemoveDuplicates {

    public static ListNode removeDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
//                slow = slow.next;
//                slow.val = fast.val;
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
