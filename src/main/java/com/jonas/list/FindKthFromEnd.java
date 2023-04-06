package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 单链表的倒数第 k 个节点
 * <p>
 * 时间复杂度是 O(N)
 */
public class FindKthFromEnd {

    // 返回链表的倒数第 k 个节点
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildRandomList(5);
        ListUtil.printList(head);
        ListNode node = findFromEnd(head, 2);
        System.out.println(node.val);
    }
}
