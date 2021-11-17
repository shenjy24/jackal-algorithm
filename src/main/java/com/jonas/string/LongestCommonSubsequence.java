package com.jonas.string;

/**
 * 最长公共子序列 Leetcode (1143)
 *
 * 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //dp[i][j]表示text1[0..i]和text2[0..j]的最长公共子序列的长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        int size = longestCommonSubsequence("abcde", "ace");
        System.out.println(size);
    }
}
