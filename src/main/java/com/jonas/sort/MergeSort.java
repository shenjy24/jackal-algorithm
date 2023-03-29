package com.jonas.sort;

/**
 * 归并排序: 将两个有序的数组归并为一个更大的有序数组
 * <p>
 * 归并字面上的意思是合并，归并算法的核心思想是分治法，就是将一个数组一刀切两半，递归切，直到切成单个元素，然后重新组装合并，
 * 单个元素合并成小数组，两个小数组合并成大数组，直到最终合并完成，排序完毕。
 * <p>
 * 类型：二叉树的后序遍历
 * 思路：所有递归的算法，你甭管它是干什么的，本质上都是在遍历一棵（递归）树，然后在节点（前中后序位置）上执行代码，
 * 你要写递归算法，本质上就是要告诉每个节点需要做什么。
 *
 * 时间复杂度：O(NlogN)
 *
 * @author shenjy 2020/12/20
 */
public class MergeSort {
    //归并所需的辅助数组
    private static int[] aux;

    public static void mergeSort(int[] a) {
        // 先给辅助数组开辟内存空间
        aux = new int[a.length];
        // 排序整个数组（原地修改）
        sort(a, 0, a.length - 1);
    }

    // 定义：将子数组 nums[lo..hi] 进行排序
    private static void sort(int[] a, int start, int end) {
        if (start >= end) {
            // 单个元素不用排序
            return;
        }
        // 这样写是为了防止溢出，效果等同于 (start + end) / 2
//        int mid = (start + end) / 2;
        int mid = start + (end - start) / 2;
        sort(a, start, mid);         //将左半边排序
        sort(a, mid + 1, end);  //将右半边排序
        /****** 后序位置 ******/
        // 此时两部分子数组已经被排好序
        // 合并两个有序数组，使 nums[start..end] 有序
        merge(a, start, mid, end);   //合并结果
        /*********************/
    }

    // 将 nums[start..mid] 和 nums[mid+1..end] 这两个有序数组合并成一个有序数组
    private static void merge(int[] a, int start, int mid, int end) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int k = start; k <= end; k++) {
            aux[k] = a[k];
        }
        // 数组双指针技巧，合并两个有序数组
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) { //归并回到a[start...end]
            if (i > mid) {
                // 左半边数组已全部被合并
                a[k] = aux[j++];
            } else if (j > end) {
                // 右半边数组已全部被合并
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        mergeSort(list);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
