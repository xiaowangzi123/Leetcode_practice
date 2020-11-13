package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/13
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        Solution obj = new Solution();
        System.out.println(Arrays.toString(obj.findRelativeRanks(arr)));
//        System.out.println(Integer.compare(1, 2));
    }

    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }

        Integer[] arrs = Arrays.stream(nums).boxed().toArray(Integer[]::new);

//        Integer[] arrs = IntStream.of(nums).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
//        Comparator<Integer> myComparator = (a, b) -> Integer.compare(nums[a], nums[b]);
//        Arrays.sort(arrs, Collections.reverseOrder());
        /*Arrays.sort(index, myComparator.reversed());

        System.out.println(Arrays.toString(arrs));

        String[] res = new String[nums.length];
        for (int i=0; i<arrs.length; i++){

        }
        return res;*/

        Comparator<Integer> myComparator = (a, b) -> Integer.compare(nums[a], nums[b]);
        Arrays.sort(index, myComparator.reversed()); // collections.reverseOrder()
        String[] result = new String[nums.length];
        for (int i = 0; i < index.length; ++i) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
