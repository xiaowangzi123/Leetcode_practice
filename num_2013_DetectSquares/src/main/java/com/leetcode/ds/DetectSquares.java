package com.leetcode.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/1/26
 * @description: 检测正方形
 */
class DetectSquares {

    Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<Integer, Map<Integer, Integer>>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        map.putIfAbsent(y, new HashMap<Integer, Integer>());
        Map<Integer, Integer> yCnt = map.get(y);
        yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!map.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> yCnt = map.get(y);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
            int col = entry.getKey();
            Map<Integer, Integer> colCnt = entry.getValue();
            if (col != y) {
                // 根据对称性，这里可以不用取绝对值
                int d = col - y;
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10});
        detectSquares.count(new int[]{14, 8});
        detectSquares.add(new int[]{11, 2});
        detectSquares.count(new int[]{11, 10});
    }
}
