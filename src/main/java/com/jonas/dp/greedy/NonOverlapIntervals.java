package com.jonas.dp.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shenjy
 * @createTime 2023/9/17 15:56
 * @description <a href="https://leetcode.com/problems/non-overlapping-intervals/">Non-overlapping Intervals</a>
 */
public class NonOverlapIntervals {

    /**
     * 给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间
     *
     * @param intervals 闭区间数组
     * @return 不相交区间个数
     */
    public static int nonOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 按照end排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                long n = (long)a[1] - (long)b[1];
                return (int) n;
            }
        });
        // 不相见区间数量至少为1
        int count = 1;
        int xEnd = intervals[0][1];
        for (int[] interval : intervals) {
            // 区间的start大于区间x的end，则是不相交区间
            if (interval[0] > xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{-2147483646,-2147483645},{2147483646,2147483647}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                long n = (long)a[1] - (long)b[1];
                if (n < 0) {
                    return -1;
                } else if (n > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < intervals.length;i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.println(intervals[i][j]);
            }
        }
    }
}
