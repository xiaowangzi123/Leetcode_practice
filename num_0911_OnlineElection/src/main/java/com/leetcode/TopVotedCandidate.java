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
        this.times = times;
        lists = new ArrayList<>();
        map = new HashMap<>();
        int max = 0;
        for (int p : persons) {
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p) >= map.getOrDefault(max, 0)) {
                max = p;
            }
            lists.add(max);
        }
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
        //0, 1, 1, 0, 0, 1
        TopVotedCandidate obj = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));
        System.out.println(obj.q(15));
        System.out.println(obj.q(24));
        System.out.println(obj.q(8));
        System.out.println("-----------------------------");

        //0,0,0,0,0,0,0,0,0,0
        TopVotedCandidate obj2 = new TopVotedCandidate(new int[]{0, 0, 0, 0, 1}, new int[]{0, 6, 39, 52, 75});
        System.out.println(obj2.q(45));
        System.out.println(obj2.q(49));
        System.out.println(obj2.q(59));
        System.out.println(obj2.q(68));
        System.out.println(obj2.q(42));
        System.out.println(obj2.q(37));
        System.out.println(obj2.q(99));
        System.out.println(obj2.q(26));
        System.out.println(obj2.q(78));
        System.out.println(obj2.q(43));
    }
}
