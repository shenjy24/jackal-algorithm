package com.jonas.backtrack;

import com.jonas.util.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 一个无序、不重复数组，输出N个元素，使得N个元素的和相加为M
 */
public class ArraySum {

    private static LinkedList<Integer> res = new LinkedList<>();

    public static List<Integer> arraySum(int[] a, int n, int m) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(a, track, n, m, 0);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, int n, int m, int index) {
        if ((track.size() == n && sum(track) == m)) {
            res = new LinkedList<>(track);
            return;
        }
        if (0 != res.size() || sum(track) > m) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            track.add(num);
            backtrack(nums, track, n, m, i + 1);
            track.removeLast();
        }
    }

    private static int sum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 10, 1, 6, 4, 5, 3};
        ArrayUtil.printArray(nums);
        List<Integer> list = arraySum(nums, 3, 10);
        System.out.println(list);
    }
}
