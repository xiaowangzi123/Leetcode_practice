package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description :
 */
public class Solution1046 {
    public static void main(String[] args) {
        Solution1046 obj = new Solution1046();
        int[] arr = {2, 7, 4, 1, 8, 1};
//        int[] arr = {1, 3};
        System.out.println(obj.lastStoneWeight2(arr));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : stones) {
            queue.offer(num);
        }
        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }

    public int lastStoneWeight2(int[] stones) {

        List<Integer> list = new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }
        Collections.sort(list);
        while (list.size() > 1) {
            int n = list.size();
            int a = list.get(n - 1);
            int b = list.get(n - 2);
            if (a == b) {
                list.remove(n - 1);
                list.remove(n - 2);
            } else if (a > b) {
                list.remove(n - 1);
                list.set(n - 2, a - b);
                Collections.sort(list);
            }
        }
        return list.size() == 0 ? 0 : list.get(0);
    }
}