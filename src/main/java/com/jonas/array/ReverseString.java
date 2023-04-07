package com.jonas.array;

/**
 * 反转数组 (leetcode: 344)
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c'};
        reverseString(str);
        for (char ch : str) {
            System.out.print(ch);
        }
    }
}
