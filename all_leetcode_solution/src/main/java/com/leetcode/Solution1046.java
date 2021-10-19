package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description :
 */
public class Solution1046 {
    public static void main(String[] args) {
        Solution1046 obj = new Solution1046();
        int[] arr = {2, 7, 4, 1, 8, 1};
        System.out.println(obj.lastStoneWeight(arr));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : stones) {
            queue.offer(num);
        }
        while (queue.size() > 2) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }
}