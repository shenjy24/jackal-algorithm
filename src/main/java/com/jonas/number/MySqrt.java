package com.jonas.number;

/**
 * @author shenjy
 * @createTime 2022/10/8 17:37
 * @description MySqrt leetcode 69
 */
public class MySqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            long res = (long) middle * middle;
            if (res > x) {
                right = middle - 1;
            } else if (res < x) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
    }
}
