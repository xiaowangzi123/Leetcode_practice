package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2021/12/11
 * @description: 在线选举
 */
public class TopVotedCandidate {
    List<Integer> lists;
    Map<Integer, Integer> map;
    int[] times;


    public TopVotedCandidate(int[] persons, int[] times) {
        lists = new ArrayList<>();
        map = new HashMap<>();
        int max = 0;
        for (int p : persons) {
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p) >= map.getOrDefault(max, 0)) {
                max = p;
            }
            lists.add(p);
        }
        this.times = times;
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return lists.get(l);

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
