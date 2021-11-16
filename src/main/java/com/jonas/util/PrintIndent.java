package com.jonas.util;

/**
 * 打印缩进
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-11-16
 */
public class PrintIndent {

    // 全局变量，记录递归函数的递归层数
    private int count = 0;

    // 输入 n，打印 n 个 tab 缩进
    public void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" ");
        }
    }
}
