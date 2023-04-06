package com.jonas.array;

/**
 * 删除有序数组中的重复项 (leetcode: 26)
 */
public class RemoveDuplicates {

    /**
     * 原地修改，返回长度
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
