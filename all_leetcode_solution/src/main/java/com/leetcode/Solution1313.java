package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description :
 */
public class Solution1313 {
    public static void main(String[] args) {
        Solution1313 obj = new Solution1313();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(obj.decompressRLElist(nums)));
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i] > 0) {
                ans.add(nums[i + 1]);
                nums[i]--;
            }
        }
//        return ans.stream().mapToInt(Integer::intValue).toArray();
        int[] arr = new int[ans.size()];
        for (int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}