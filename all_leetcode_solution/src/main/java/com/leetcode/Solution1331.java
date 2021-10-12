package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1331 {

    public static void main(String[] args) {
        Solution1331 obj = new Solution1331();
        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(obj.arrayRankTransform(arr)));


    }

    public int[] arrayRankTransform(int[] arr) {
        int[] ans = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int index = 1;
        for (int a : arr) {
            //有数据相等的跳过
            if (!map.containsKey(a)) {
                map.put(a, index++);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(ans[i]);
        }
        return ans;
    }
}