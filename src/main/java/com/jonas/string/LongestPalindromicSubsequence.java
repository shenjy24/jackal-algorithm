package com.jonas.string;

/**
 * 最长回文子序列 LeetCode (516)
 *
 * 问题：给定一个字符串s，找到其中最长的回文子序列
 * 示例：
 *   输入："bbbab"
 *   输出：4
 *   解释：一个可能的最长回文子序列为 "bbbb"
 *
 * 问题详解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484666&idx=1&sn=e3305be9513eaa16f7f1568c0892a468&chksm=9bd7faf2aca073e4f08332a706b7c10af877fee3993aac4dae86d05783d3d0df31844287104e&scene=21#wechat_redirect
 */
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubsequence(String s) {
        int n = s.length();
        //dp数组的定义：在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //要计算dp[i][j],需要先计算出左、下、左下的值
        //从下层，往右遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence("bbbab"));
    }
}
