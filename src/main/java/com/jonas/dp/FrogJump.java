package com.jonas.dp;

/**
 * 青蛙跳台阶算法
 */
public class FrogJump {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     *
     * 本质上就是斐波那契数列
     */
    public int frogJump1(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * https://blog.csdn.net/lilong117194/article/details/83926776
     */
    public int frogJump2(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FrogJump app = new FrogJump();
        System.out.println(app.frogJump1(3));
        System.out.println(app.frogJump2(3));
    }
}
