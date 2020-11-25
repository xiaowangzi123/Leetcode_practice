package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/25
 * @description：
 */
public class Solution0898 {
    public static void main(String[] args) {
        Solution0898 obj = new Solution0898();
        int[] arr = {1, 1, 2};
        System.out.println(obj.subarrayBitwiseORs(arr));
    }

    public int subarrayBitwiseORs(int[] A) {
        int [] num = new int[A.length];
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<A.length; ++i){
            for (int j=0; j<A.length-i; ++j){
                num[j] |= A[i+j];
                set.add(num[j]);
            }
        }
        return set.size();
    }
}