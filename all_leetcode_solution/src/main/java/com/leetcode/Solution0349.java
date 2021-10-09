package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0349 {
    public static void main(String[] args) {
        Solution0349 obj = new Solution0349();
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(obj.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(obj.intersection2(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> retset = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                retset.add(nums2[j]);
            }
        }

//        int[] ans = retset.toArray(new Integer(retset.size()));
        Integer[] ans = retset.toArray(new Integer[0]);
        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
        /*int[] resarr = new int[retset.size()];
        int k = 0;
        for (int x : retset) {
            resarr[k++] = x;
        }
        return resarr;*/

    }

    public int[] intersection2(int[] nums1, int[] nums2) {


        return nums1;
    }


}