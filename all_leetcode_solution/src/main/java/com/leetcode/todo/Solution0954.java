package com.leetcode.todo;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/4/1
 * @description: TODO
 * 954. 二倍数对数组
 */
public class Solution0954 {
    public static void main(String[] args) {
        Solution0954 obj = new Solution0954();
        System.out.println(obj.canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(obj.canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(obj.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            // 无法找到足够的 2x 与 x 配对
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

}