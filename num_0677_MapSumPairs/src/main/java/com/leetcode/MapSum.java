package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/14
 * @description : 键值映射
 */
public class MapSum {

    Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        for (String s : map.keySet()) {
            if (s.startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }

}