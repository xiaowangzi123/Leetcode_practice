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

    //{x, {y : 点(x,y)数量}}
    Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> cntMap = map.get(x);
        cntMap.put(y, cntMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int a = point[0], b = point[1];
        if (!map.containsKey(a)) {
            return 0;
        }
        //在同一水平上的点，纵坐标一样
        Map<Integer, Integer> checkMap = map.get(a);
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            int x = entry.getKey();
            Map<Integer, Integer> curMap = entry.getValue();
            if (a != x) {
                // 根据对称性，这里可以不用取绝对值
                int d = a - x;
                res += checkMap.getOrDefault(b + d, 0) * curMap.getOrDefault(b, 0) * curMap.getOrDefault(b + d, 0);
                res += checkMap.getOrDefault(b - d, 0) * curMap.getOrDefault(b, 0) * curMap.getOrDefault(b - d, 0);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10});
        detectSquares.count(new int[]{14, 8});
        detectSquares.add(new int[]{11, 2});
        detectSquares.count(new int[]{11, 10});
    }
}
