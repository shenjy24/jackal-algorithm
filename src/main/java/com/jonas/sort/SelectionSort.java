package com.jonas.sort;

/**
 * 选择排序
 *
 * 思路：在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
 * 以此类推，直到所有元素均排序完毕
 */
public class SelectionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                }
            }
        }
    }
}
