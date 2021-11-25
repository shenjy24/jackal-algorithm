package com.jonas.util;

/**
 * TreeUtil
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-11-16
 */
public class TreeUtil {

    //创建测试用的二叉树

    /**
     *       100
     *      /   \
     *     1     5
     *      \   / \
     *       3 2   4
     */
    public static TreeNode buildTree() {
        TreeNode head = new TreeNode(100);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        head.left = node1;
        head.right = node5;
        node1.right = node3;
        node5.left = node2;
        node5.right = node4;
        return head;
    }
}
