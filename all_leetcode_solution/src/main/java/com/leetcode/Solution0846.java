package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2021/12/30
 * @description: 一手顺子
 */
public class Solution0846 {
    public static void main(String[] args) {
        Solution0846 obj = new Solution0846();

        System.out.println(obj.isNStraightHand2(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(obj.isNStraightHand2(new int[]{1, 2, 3, 4, 5}, 4));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : hand) {
            if (!map.containsKey(i)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = i + j;
                if (!map.containsKey(num)) {
                    return false;
                }
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return true;
    }

    public boolean isNStraightHand2(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : hand) {
            if (map.get(i) > 0) {
                for (int j = 0; j < groupSize; j++) {
                    if (!map.containsKey(i+j)) {
                        return false;
                    }
                    map.put(i+j,map.get(i+j)-1);
                }
            }
        }
        return true;
    }
}