package com.jonas.list;

import com.jonas.util.ListNode;

/**
 * 寻找环起点
 */
public class DetectCircle {

    public static boolean hasCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 求环长
     */
    public static int circleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) {
            return 0;
        }
        fast = fast.next.next;
        slow = slow.next;
        int len = 1;
        while (slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
            len++;
        }
        return len;
    }

    /**
     * 第一次相遇时，slow走的长度 S = LenA + x;
     * 第一次相遇时，fast走的长度 2S = LenA + n*R + x;
     * 所以可以知道，LenA + x =  n*R;　　LenA = n*R -x;
     */
    public static ListNode circleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode buildCircle() {
        ListNode head = new ListNode(0);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);

        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p2;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = buildCircle();
        System.out.println(hasCircle(head));
        System.out.println(circleLength(head));
        ListNode start = circleStart(head);
        System.out.println(start.val);
    }
}
