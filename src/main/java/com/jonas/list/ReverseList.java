package com.jonas.list;

import com.jonas.util.ListNode;
import com.jonas.util.ListUtil;

/**
 * 反转整个链表
 */
public class ReverseList {

    /**
     * 对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的reverse函数定义是这样的：
     *
     * 输入一个节点head，将「以head为起点」的链表反转，并返回反转之后的头结点。
     */
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

    /**
     * 使用迭代方式进行反转
     */
    public static ListNode reverseByIteration(ListNode head) {
        //base case : 链表只有一个节点的时候反转也是它自己，直接返回即可
        if (null == head.next) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head, nxt;
        while (null != cur) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList();
        ListUtil.printList(head);
        ListNode newHead = reverse(head);
        ListUtil.printList(newHead);

        ListNode headByIteration = ListUtil.buildList();
        ListUtil.printList(headByIteration);
        ListNode newHeadByIteration = reverseByIteration(headByIteration);
        ListUtil.printList(newHeadByIteration);
    }
}
