package com.jonas.tree;

import com.jonas.util.TreeNode;
import com.jonas.util.TreeUtil;

/**
 * 遍历二叉树
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-11-16
 */
public class TraverseBinaryTree {

    // 全局变量，记录递归函数的递归层数
    private static int count = 0;

    // 输入 n，打印 n 个 tab 缩进
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("*");
        }
    }

    public static void traverse(TreeNode node) {
        printIndent(count++);
        System.out.printf("val = %s\n", null != node ? node.val : "null");

        if (null == node) {
            printIndent(--count);
            System.out.printf("return\n");
            return;
        }

        traverse(node.left);
        traverse(node.right);

        printIndent(--count);
        System.out.printf("return\n");
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtil.buildTree();
        traverse(head);
    }
}
