package com.jonas.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串 (leetcode: 76)
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        // 需要满足的字符个数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        // 滑动窗口双指针
        int left = 0, right = 0;
        // 表示窗口中满足的字符数
        int valid = 0;
        // 用于记录字串的起始位置和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 将字符加入窗口
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            right++;
            // 判断该字符数量是否达标
            if (window.get(ch).equals(need.get(ch))) {
                valid++;
            }
            // 当前窗口已包含所有指定字符，缩小窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 将左边字符移出窗口
                char removeChar = s.charAt(left);
                window.put(removeChar, window.getOrDefault(removeChar, 1) - 1);
                left++;
                if (need.getOrDefault(removeChar, 0) > window.get(removeChar)) {
                    valid--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
