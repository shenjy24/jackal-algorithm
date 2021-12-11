package com.jonas.dp;

/**
 * LeetCode 45
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    //动态规划 时间复杂度是O(n^2)，空间复杂度是O(n)
    public static int jump(int[] nums) {
        //dp[i]表示跳到下标为i的位置最少需要几次跳跃
        int[] dp = new int[nums.length];
        //base case
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE; //初始化为一个不可能的值
            //状态转移方程：dp[i]=Math.min(dp[j]+1, dp[i])，其中dp[j]表示从下标[0,i)中能够能够走到位置i的所有情况。
            for (int j = 0; j < i; j++) {
                //如果从j可以跳到i
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    //贪心算法 时间复杂度是O(n)，空间复杂度是O(1)
    public static int jumpGreedy(int[] nums) {
        int fastest = 0, end = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //当前位置最远可达坐标
            fastest = Math.max(fastest, i + nums[i]);
            //每次都跳跃到最远坐标
            if (end == i) {
                jumps++;
                end = fastest;
            }
        }
        return jumps;
    }
}
