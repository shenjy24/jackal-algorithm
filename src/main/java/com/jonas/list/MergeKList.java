package com.jonas.list;

import com.jonas.util.ListNode;

import java.util.PriorityQueue;

/**
 * 合并K个有序链表 (leetcode: 23)
 */
public class MergeKList {

    /**
     * 借助最小堆
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }
        ListNode dummy = new ListNode(-1), p = dummy;
        //最小堆，用于获取链表值最小的头节点
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (null != head) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode minHead = pq.poll();
            p.next = minHead;
            p = p.next;
            if (null != minHead.next) {
                pq.add(minHead.next);
            }
        }
        return dummy.next;
    }
}
