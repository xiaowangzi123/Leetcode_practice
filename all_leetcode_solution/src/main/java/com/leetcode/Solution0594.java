package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0594 {
    public static void main(String[] args) {
        Solution0594 obj = new Solution0594();
        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(obj.findLHS(arr));
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //如果map的key集中包含当前值+1,符合条件
            if (map.containsKey(entry.getKey() + 1)) {
                //将当前key值对应的value以及key+1对应的value与ans比较，大的保留
                ans = Math.max(ans, entry.getValue() + map.get(entry.getKey() + 1));
            }
        }
        return ans;
    }
}