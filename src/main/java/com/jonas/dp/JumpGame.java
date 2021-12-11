package com.jonas.dp;

/**
 * LeetCode 55
 * https://leetcode.com/problems/jump-game
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-12-11
 */
public class JumpGame {

    //动态规划解法 时间复杂度是O(n^2)，空间复杂度是O(n)
    public boolean canJump(int[] nums) {
        //dp表示当前位置能否到达
        boolean[] dp = new boolean[nums.length];
        //base case : 第一个位置默认可达
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //判断位置i是否可达的条件：位置j本身可达并且通过位置j可到达位置i
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    //贪心算法1 时间复杂度是O(n)，空间复杂度是O(1)
    //从前往后推，看最远可到达距离是否大于等于 nums.length - 1
    public boolean canJumpGreedy1(int[] nums) {
        int fastest = 0;    //最远可到达
        for (int i = 0; i < nums.length; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            //遇到0的情况
            if (fastest <= i) return false;
        }
        return fastest >= (nums.length - 1);
    }

    //贪心算法2 时间复杂度是O(n)，空间复杂度是O(1)
    //从后往前推，从后往前判断每个坐标是否可达，如果可以推断到坐标0可达，则整体可达
    public boolean canJumpGreedy2(int[] nums) {
        //坐标代表当前可达的最后节点，这个坐标初始等于nums.length-1
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            //判断当前位置是否可达，如果可达则向前移动这个坐标，直到遍历结束
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        //如果这个坐标等于0，那么认为可达，否则不可达
        return lastPosition == 0;
    }
}
