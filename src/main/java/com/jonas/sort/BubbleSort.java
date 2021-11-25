package com.jonas.sort;

import com.jonas.util.ArrayUtil;

/**
 * 冒泡排序
 *
 * 思路：比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个，即需要进行length-1次。
 */
public class BubbleSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {  //外层循环控制排序趟数
            for (int j = 0; j < a.length - i - 1; j++) { //内层循环控制每一趟排序多少次
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    // 优化：设定一个临时遍历来标记该数组是否已经有序，如果有序了就不用遍历了
    public static void sortOptimization(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean isSort = true;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        sort(list);
        ArrayUtil.printArray(list);
        sortOptimization(list);
        ArrayUtil.printArray(list);
    }
}
