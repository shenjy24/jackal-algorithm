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

    /**
     * 前序遍历
     *
     * @param node 头节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (null == node) {
            return;
        }

        System.out.println(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     *
     * @param node 头节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (null == node) {
            return;
        }

        inOrderTraverse(node.left);
        System.out.println(node.val);
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     *
     * @param node 头节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (null == node) {
            return;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtil.buildTree();
        preOrderTraverse(head);
        System.out.println();
        inOrderTraverse(head);
        System.out.println();
        postOrderTraverse(head);
        System.out.println();
    }
}
