package com.jonas.string;

import java.util.Stack;

/**
 * RemoveDuplicateLetters (316)
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-06-01
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String res = removeDuplicateLetters("cbacdcbc");
        System.out.println(res.equals("acdb"));
    }

    public static String removeDuplicateLetters(String s) {
        //存储不重复的字符
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) continue;

            while (!stk.empty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (0 == count[stk.peek()]) {
                    break;
                }
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stk.empty()) {
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
}
