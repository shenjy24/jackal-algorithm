package com.jonas.number;

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
}
