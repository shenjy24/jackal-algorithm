package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 反转前N个节点
 */
public class ReverseNList {

    private static ListNode successor = null;

    //反转以 head 为起点的 n 个节点，返回新的头结点，索引从1开始
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

    //使用迭代方式反转
    public static ListNode reverseNByIteration(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }

        //获得新头结点和后继结点
        ListNode last = head;
        while (n-- > 1) {
            last = last.next;
        }
        ListNode successor = last.next;

        //反转部分链表
        ListNode pre = null;
        ListNode cur = head, nxt;
        while (successor != cur) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverseN(head, 2);
        ListUtil.printList(newHead);

        ListNode headByIteration = ListUtil.buildList();
        ListUtil.printList(headByIteration);
        ListNode newHeadByIteration = reverseNByIteration(headByIteration, 2);
        ListUtil.printList(newHeadByIteration);
    }
}
