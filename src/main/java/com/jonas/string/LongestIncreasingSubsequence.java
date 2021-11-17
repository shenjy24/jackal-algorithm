package com.jonas.string;

/**
 * 最长递增子序列 LeetCode (300)
 *
 * 问题：给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 示例：
 *   输入: nums = [10,9,2,5,3,7,101,18]
 *   输出: 4
 *   解释: 最长递增子序列是 [2,3,7,101], 因此长度为4
 *
 * 问题详解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&idx=1&sn=df58ef249c457dd50ea632f7c2e6e761&chksm=9bd7fa5aaca0734c29bcf7979146359f63f521e3060c2acbf57a4992c887aeebe2a9e4bd8a89&scene=21#wechat_redirect
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case : dp 数组应该全部初始化为 1，因为子序列最少也要包含自己，所以长度最小为 1
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //返回dp数组的最大值
        int len = 0;
        for (int i = 0; i < dp.length; i++) {
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
