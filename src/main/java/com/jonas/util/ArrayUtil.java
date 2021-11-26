package com.jonas.util;

import java.util.Random;

public class ArrayUtil {

    private static final Random random = new Random();

    public static int[] buildArray(int count) {
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = random.nextInt(100);
        }
        return nums;
    }

    public static void printArray(int[] nums) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            content.append(nums[i]);
            if (i != nums.length - 1) {
                content.append(",");
            }
        }
        System.out.println(content);
    }
}
