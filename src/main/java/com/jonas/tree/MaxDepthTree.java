package com.jonas.tree;

import com.jonas.util.TreeNode;

/**
 * 二叉树的最大深度
 */
public class MaxDepthTree {

    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        return Math.max(left, right) + 1;
    }
}
