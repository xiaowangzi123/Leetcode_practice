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
//        System.out.println(obj.minJumps(new int[]{100, 100}));
        System.out.println(obj.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(obj.minJumps2(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
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

        //遍历过的元素集合
        Set<Integer> set = new HashSet<>();
        //存储下标和到达此下标需要的步数
        Queue<int[]> queue = new ArrayDeque<>();
        //添加第一个坐标到队列中
        queue.offer(new int[]{0, 0});
        set.add(0);

        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int val = arr[idx];
            step++;
            //到达与当前元素相同的位置
            if (indexMap.containsKey(val)) {
                for (int i : indexMap.get(val)) {
                    if (set.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                indexMap.remove(val);
            }
            //到达当前元素的下一个位置
            if (idx + 1 < n && set.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            //到达当前元素的前一个位置
            if (idx - 1 >= 0 && set.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }

    //超时
    public int minJumps2(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.putIfAbsent(arr[i], new ArrayList<>());
            indexMap.get(arr[i]).add(i);
        }

        boolean[] used = new boolean[n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        used[0] = true;
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int val = arr[idx];
            step++;
            if (indexMap.containsKey(val)) {
                for (int i : indexMap.get(val)) {
                    if (!used[i]) {
                        queue.offer(new int[]{i, step});
                        used[i] = true;
                    }
                }
                indexMap.remove(val);
            }
            if (idx + 1 < arr.length && !used[idx + 1]) {
                queue.offer(new int[]{idx + 1, step});
                used[idx + 1] = true;
            }
            if (idx - 1 >= 0 && !used[idx - 1]) {
                queue.offer(new int[]{idx - 1, step});
                used[idx - 1] = true;
            }
        }
        return -1;

    }

}