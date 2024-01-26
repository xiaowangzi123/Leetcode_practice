package com.leetcode.s2801_2900;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计趣味子数组的数目
 * https://blog.csdn.net/qq_42958831/article/details/132664762
 */
public class Solution2845 {
    public static void main(String[] args) {

    }

    /**
     * TODO
     * <p>
     * 1. 转换 设 cnt 为满足 nums[i] % m == k 的索引 i 的数量
     * 如果 nums[i] % m == k，则 nums[i] = 1，否则 nums[i] = 0
     * ==> cnt = 子数组的元素和   ==> 前缀和
     * <p>
     * 2. 取模 cnt % modulo == k  ==> (pre[r] - pre[l]) % m = k
     * ==> (pre[r] % m - pre[l] % m + m) % m = k
     * 3. 式子变形 (pre[r] % m - pre[l] % m + m) % m = k
     * (pre[r] - k + m) % m = pre[l]
     * 用哈希表记录pre[l]出现的次数  => 两数之和
     */
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (nums.get(i) % m == k) ? 1 : 0;
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for (int num : pre) {
            int target = (num % m - k + m) % m;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            map.merge(num % m, 1, Integer::sum);
        }
        return ans;
    }
}
