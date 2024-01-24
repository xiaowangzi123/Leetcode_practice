package com.leetcode.s2801_2900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 美丽塔Ⅰ
 */
public class Solution2865 {
    public static void main(String[] args) {
        Solution2865 solution = new Solution2865();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(5,3,4,1,1));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(6,5,3,9,2,7));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(3,2,5,5,2,3));
        System.out.println(solution.maximumSumOfHeights(nums1));
        System.out.println(solution.maximumSumOfHeights(nums2));
        System.out.println(solution.maximumSumOfHeights(nums3));
    }

    /**
     * 动态规划求解
     * TODO
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;
        for(int i = 0; i < n; i++){
            int temp = maxHeights.get(i);
            long sum = temp;
            for(int j = i - 1; j >= 0; j--){
                sum += Math.min(temp, maxHeights.get(j));
                temp = Math.min(temp, maxHeights.get(j));
            }
            temp = maxHeights.get(i);
            for(int k = i + 1; k < n; k++){
                sum += Math.min(temp, maxHeights.get(k));
                temp = Math.min(temp, maxHeights.get(k));
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
