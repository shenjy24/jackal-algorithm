package com.jonas.string;

/**
 * 编辑距离 LeetCode (72)
 *
 * 问题：给定两个字符串s1和s2，计算出将s1转换成s2所使用的最少操作数
 *      可以对一个字符串进行如下三种操作：
 *      1. 插入一个字符
 *      2. 删除一个字符
 *      3. 替换一个字符
 * 示例：
 *   输入：s1 = "horse", s2 = "ros"
 *   输出: 3
 *   解释： horse -> rorse (将 h 替换为 r)
 *         rorse -> rose (删除 r)
 *         rose -> ros (删除 e)
 *
 * 问题详解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484484&idx=1&sn=74594297022c84952162a68b7f739133&chksm=9bd7fa4caca0735a1364dd13901311ecd6ec4913c8db05a1ff6cae8f069627eebe8d651bbeb1&scene=21#wechat_redirect
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        // dp[i][j] 表示 s1[0..i] 和 s2[0..j] 的最小编辑距离
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //base case : 字符串与空字符的编辑距离为 i
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //相等则不需要任何操作，s1[0..i] 和 s2[0..j] 的最小编辑距离等于 s1[0..i-1] 和 s2[0..j-1] 的最小编辑距离
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i - 1][j]: 删除
                    //dp[i][j - 1]: 插入
                    //dp[i - 1][j - 1]: 替换或相等跳过
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private static int min(int i1, int i2, int i3) {
        return Math.min(i1, Math.min(i2, i3));
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
