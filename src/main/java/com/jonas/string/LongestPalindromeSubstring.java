package com.jonas.string;

/**
 * 最长回文子串 Leetcode (5)
 * 问题：给定一个字符串s，找到s中最长的回文子串。
 * 示例1：
 *   输入："babad"
 *   输出："bab"
 *   注意："aba" 也是有效答案
 * 示例2：
 *   输入："cbbd"
 *   输出："bb"
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String str = longestPalindrome("babad");
        System.out.println(str);
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //使用双指针可以处理长度为奇数和偶数的情况
    private static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
