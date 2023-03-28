package com.jonas.sort;

import java.util.Random;

/**
 * 快速排序
 * 1.选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 2.递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 *
 * 时间复杂度：设数组元素个数为 N，那么二叉树每一层的元素个数之和就是 O(N)；分界点分布均匀的理想情况下，树的层数为 O(logN)，
 *           所以理想的总时间复杂度为 O(NlogN)。
 *           如果每次 partition 切分的结果都极不均匀，快速排序就退化成选择排序了，最坏时间复杂度是 O(N^2)，空间复杂度是 O(N)
 *
 * 空间复杂度：由于快速排序没有使用任何辅助数组，所以空间复杂度就是递归堆栈的深度，也就是树高 O(logN)
 *
 * @author shenjy 2018/12/26
 */
public class QuickSort {

    /**
     * 快速排序就是一个二叉树的前序遍历
     */
    public static void quickSort(int[] numbers) {
        //打乱顺序，消除对输入的依赖
        shuffle(numbers);
        sort(numbers, 0, numbers.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) return;
        // 对 a[start..end] 进行切分
        // 使得 a[start..j-1] <= a[j] < a[j+1..end]
        int j = partition(a, start, end);
        sort(a, start, j - 1); //将左半部分a[start...j-1]排序
        sort(a, j + 1, end);    //将右半部分a[j+1...end]排序
    }

    private static int partition(int[] a, int start, int end) {
        int v = a[start];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = start + 1, j = end;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            // 找到比v大的索引
            while (i < end && a[i] <= v) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > start && a[j] > v) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }
            if (i >= j) break;
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            // 交换 nums[j] 和 nums[i]
            swap(a, i, j);
            // 此时 [lo, i] <= pivot && [j, hi] > pivot
        }
        // 将v=a[j]放入正确的位置
        // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(a, start, j);
        //a[start..j-1] <= a[j] <= a[j+1...end]达成
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(int[] a) {
        int length = a.length;
        Random rand = new Random();
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(a, randInd, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        quickSort(list);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
