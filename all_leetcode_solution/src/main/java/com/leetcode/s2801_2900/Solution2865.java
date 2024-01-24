package com.leetcode.s2801_2900;

import java.util.*;

/**
 * 美丽塔Ⅰ
 */
public class Solution2865 {
    public static void main(String[] args) {
        Solution2865 solution = new Solution2865();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 3, 4, 1, 1));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(6, 5, 3, 9, 2, 7));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(3, 2, 5, 5, 2, 3));
        System.out.println(solution.maximumSumOfHeights(nums1));
        System.out.println(solution.maximumSumOfHeights2(nums1));
        System.out.println(solution.maximumSumOfHeights(nums2));
        System.out.println(solution.maximumSumOfHeights2(nums2));
        System.out.println(solution.maximumSumOfHeights(nums3));
        System.out.println(solution.maximumSumOfHeights2(nums3));
    }

    /**
     * 美丽塔，就是选中某一个i作为最高点，向两边逐渐递减降低即可
     * 所以枚举所有点作为最高点的情况，从最高点开始，向左向右，
     * 要么是小于记录值，保留自身，更新记录值；
     * 要么大于记录值，大小改变为记录值，求和。
     * 取其中最大的情况。
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = maxHeights.get(i);
            long sum = temp;
            for (int j = i - 1; j >= 0; j--) {
                temp = Math.min(temp, maxHeights.get(j));
                sum += temp;
            }
            temp = maxHeights.get(i);
            for (int k = i + 1; k < n; k++) {
                temp = Math.min(temp, maxHeights.get(k));
                sum += temp;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public long maximumSumOfHeights2(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        Deque<Integer> stk1 = new ArrayDeque<>();
        Deque<Integer> stk2 = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            while (!stk1.isEmpty() && maxHeights.get(i) < maxHeights.get(stk1.peek())) {
                stk1.pop();
            }
            if (stk1.isEmpty()) {
                prefix[i] = (long) (i - 0 + 1) * maxHeights.get(i); //种树问题，总数等于差值+1
            } else {
                prefix[i] = prefix[stk1.peek()] + (long) (i - stk1.peek()) * maxHeights.get(i); //这里不计算stk1.top()那个索引对应值，所以不加1
            }
            stk1.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stk2.isEmpty() && maxHeights.get(i) < maxHeights.get(stk2.peek())) {
                stk2.pop();
            }
            if (stk2.isEmpty()) {
                suffix[i] = (long) (n - 1 - i + 1) * maxHeights.get(i);
            } else {
                suffix[i] = suffix[stk2.peek()] + (long) (stk2.peek() - i) * maxHeights.get(i);
            }
            stk2.push(i);
            ans = Math.max(ans, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return ans;
    }
}
