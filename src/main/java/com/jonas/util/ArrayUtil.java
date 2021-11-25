package com.jonas.util;

public class ArrayUtil {

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
