package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution {

    public static void main(String[] args) {
        int[] arrs = {1, 3, 4, 1, 5, 3};
        Solution obj = new Solution();
        System.out.println(obj.numIdenticalPairs(arrs));

        String j = "aA", s = "aAASSS";
        System.out.println(obj.numJewelsInStones(j, s));
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }


}