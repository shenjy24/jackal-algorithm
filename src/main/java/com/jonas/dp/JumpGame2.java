package com.jonas.dp;

/**
 * LeetCode 55
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame2 {

    /**
     * 贪心算法
     */
    public static int greedy(int[] nums) {
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
