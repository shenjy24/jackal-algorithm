package com.jonas.array;

/**
 * 移除元素 (leetcode: 27)
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};

    }
}
