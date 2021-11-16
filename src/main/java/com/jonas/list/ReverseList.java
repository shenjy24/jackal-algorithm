package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 反转整个链表
 */
public class ReverseList {

    public static ListNode reverse(ListNode head) {
        //base case : 链表只有一个节点的时候反转也是它自己，直接返回即可
        if (null == head.next) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverse(head);
        ListUtil.printList(newHead);
    }
}
