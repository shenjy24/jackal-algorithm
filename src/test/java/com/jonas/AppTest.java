package com.jonas;

public class AppTest {

    public static void main(String[] args) {
        AppTest app = new AppTest();
        System.out.println(-Math.pow(2, 31));
        System.out.println(app.myAtoi("+-12"));
    }

    public int myAtoi(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        s = trimHead(s);
        if (0 == s.length()) {
            return 0;
        }

        boolean position = s.charAt(0) != '-';
        s = trimSign(s);
        if (0 == s.length()) {
            return 0;
        }

        StringBuilder number = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ('-' == ch || '+' == ch) {
                continue;
            }
            if (' ' == ch || !Character.isDigit(ch)) {
                break;
            }
            number.append(ch);
        }
        if (0 == number.length()) {
            return 0;
        }
        long num = position ? Long.parseLong(number.toString()) : -Long.parseLong(number.toString());
        if (num < -Math.pow(2, 31)) {
            return (int) -Math.pow(2, 31);
        }
        if (num > (Math.pow(2, 31) - 1)) {
            return (int) (Math.pow(2, 31) - 1);
        }
        return (int) num;
    }

    private String trimHead(String s) {
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (' ' != ch) {
                break;
            }
            index++;
        }
        return s.substring(index);
    }

    private String trimSign(String s) {
        int index = 0;
        for (char ch : s.toCharArray()) {
            if ('-' != ch && '+' != ch) {
                break;
            }
            index++;
        }
        return s.substring(index);
    }
}
