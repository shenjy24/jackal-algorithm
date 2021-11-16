package com.jonas.util;

public class ListUtil {

    public static ListNode buildList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    public static void printList(ListNode head) {
        if (null == head) {
            return;
        }

        StringBuilder content = new StringBuilder();
        ListNode node = head;
        while (null != node) {
            content.append(node.val).append(" -> ");
            node = node.next;
        }
        content.append("null");
        System.out.println(content);
    }

    public static void main(String[] args) {
        ListNode head = buildList();
        printList(head);
    }
}
