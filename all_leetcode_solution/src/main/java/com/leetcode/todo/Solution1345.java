package com.leetcode.todo;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/21
 * @description: 跳跃游戏 IV
 * TODO
 */
public class Solution1345 {
    public static void main(String[] args) {
        Solution1345 obj = new Solution1345();
        System.out.println(obj.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        //把相同元素的下标放在一起
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.putIfAbsent(arr[i], new ArrayList<>());
            indexMap.get(arr[i]).add(i);
        }

        Set<Integer> visitedIndex = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visitedIndex.add(0);
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int v = arr[idx];
            step++;
            if (indexMap.containsKey(v)) {
                for (int i : indexMap.get(v)) {
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                indexMap.remove(v);
            }
            if (idx + 1 < arr.length && visitedIndex.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;

    }
}