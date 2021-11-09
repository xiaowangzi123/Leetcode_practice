package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 圆形赛道上经过次数最多的扇区
 */
public class Solution1560 {
    public static void main(String[] args) {
        Solution1560 obj = new Solution1560();
        int[] arr = {1, 3, 1, 2};
        System.out.println(obj.mostVisited(4, arr));
        int[] arr2 = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(obj.mostVisited(2, arr2));
        int[] arr3 = {16, 8};
        System.out.println(obj.mostVisited(17, arr3));
        System.out.println(obj.mostVisited2(17, arr3));
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < rounds.length; i++) {
            if (i == 1) {
                map.put(rounds[0], map.getOrDefault(rounds[0], 0) + 1);
            }
            if (rounds[i] > rounds[i - 1]) {
                for (int j = rounds[i - 1] + 1; j <= rounds[i]; j++) {

                    map.put(j, map.getOrDefault(j, 0) + 1);
                    max = Math.max(max, map.get(j));
                }
            } else {
                for (int j = 1; j <= rounds[i]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    max = Math.max(max, map.get(j));
                }
                for (int j = rounds[i - 1] + 1; j <= n; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    max = Math.max(max, map.get(j));
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> mostVisited2(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int len = rounds.length, i = rounds[0], j = rounds[len - 1];
        if (i < j) {
            for (int k = i; k <= j; k++) {
                ans.add(k);
            }
        } else {
            for (int k = 1; k <= j; k++) {
                ans.add(k);
            }
            for (int k = i; k <= n; k++) {
                ans.add(k);
            }
        }
        return ans;
    }
}