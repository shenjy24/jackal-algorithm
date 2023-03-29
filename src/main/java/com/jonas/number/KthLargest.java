package com.jonas.number;

import com.jonas.sort.QuickSort;
import com.jonas.util.ArrayUtil;

import java.util.PriorityQueue;

/**
 * 数组中的第 K 个最大元素
 */
public class KthLargest {

    /**
     * 二叉堆（优先队列）解法
     */
    public static int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            // 每个元素都要过一遍二叉堆
            queue.offer(num);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return queue.peek();
    }

    /**
     * 使用快速选择算法，是快速排序的变体
     */
    public static int quickSelect(int[] nums, int k) {
        // 首先随机打乱数组
        ArrayUtil.shuffle(nums);
        int start = 0, end = nums.length - 1;
        // 转化成「排名第 k 的元素」
        k = nums.length - k;
        while (start <= end) {
            // 在 nums[lo..hi] 中选一个分界点
            int p = QuickSort.partition(nums, start, end);
            if (p > k) {
                // 第 k 大的元素在 nums[lo..p-1] 中
                end = p - 1;
            } else if (p < k) {
                // 第 k 大的元素在 nums[p+1..hi] 中
                start = p + 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }


}
