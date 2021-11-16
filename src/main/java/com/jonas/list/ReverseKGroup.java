package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * k 个一组反转链表
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (a == null) {
                return head;
            }
            a = a.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, a);
        // 递归反转后续链表并连接起来
        head.next = reverseKGroup(a, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverseKGroup(head, 2);
        ListUtil.printList(newHead);
    }
}
