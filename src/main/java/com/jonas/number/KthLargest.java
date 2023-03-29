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
     * 时间复杂度：二叉堆插入和删除的时间复杂度和堆中的元素个数有关，在这里我们堆的大小不会超过 k，所以插入和删除元素的复杂度是 O(logk)，
     *           再套一层 for 循环，假设数组元素总数为 N，总的时间复杂度就是 O(Nlogk)。
     * 空间复杂度：空间复杂度很显然就是二叉堆的大小，为 O(k)
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
     * 时间复杂度：1. 最好情况下，每次 partition 函数切分出的 p 都恰好是正中间索引 (lo + hi) / 2（二分），
     *           且每次切分之后会到左边或者右边的子数组继续进行切分，那么 partition 函数执行的次数是 logN，每次输入的数组大小缩短一半。
     *           所以总的时间复杂度为：N + N/2 + N/4 + N/8 + ... + 1 = 2N = O(N) （等比数列）
     *           2. 类似快速排序，快速选择算法中的 partition 函数也可能出现极端情况，最坏情况下 p 一直都是 lo + 1 或者一直都是 hi - 1，
     *           这样的话时间复杂度就退化为 O(N^2) 了，N + (N - 1) + (N - 2) + ... + 1 = O(N^2)
     *           这也是我们在代码中使用 shuffle 函数的原因，通过引入随机性来避免极端情况的出现，让算法的效率保持在比较高的水平。
     *           随机化之后的快速选择算法的复杂度可以认为是 O(N)。
     *
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
