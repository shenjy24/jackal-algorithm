package com.jonas.tree;

import com.jonas.util.TreeNode;
import com.jonas.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 遍历二叉树
 * 1. 深度优先遍历：前序、中序、后续
 * 2. 广度优先遍历
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-11-16
 */
public class TraverseBinaryTree {

    /**
     * 前序遍历
     *
     * @param root 头节点
     */
    public static void preOrderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        /* 前续遍历代码位置 */
        System.out.println(root.val);
        /* 前续遍历代码位置 */
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root 头节点
     */
    public static void inOrderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderTraverse(root.left);
        /* 中续遍历代码位置 */
        System.out.println(root.val);
        /* 中续遍历代码位置 */
        inOrderTraverse(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root 头节点
     */
    public static void postOrderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        /* 后续遍历代码位置 */
        System.out.println(root.val);
        /* 后续遍历代码位置 */
    }

    /**
     * 层级遍历/广度优先遍历
     *
     * @param root 头节点
     */
    public static void levelTraverse(TreeNode root) {
        if (root == null) return;
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            /* 层级遍历代码位置 */
            System.out.println(cur.val);
            /* 层级遍历代码位置 */

            if (null != cur.left) {
                queue.offer(cur.left);
            }

            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree();
        preOrderTraverse(root);
        System.out.println();
        inOrderTraverse(root);
        System.out.println();
        postOrderTraverse(root);
        System.out.println();
        levelTraverse(root);
    }
}
