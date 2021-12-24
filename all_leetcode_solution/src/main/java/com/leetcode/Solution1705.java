package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 吃苹果的最大数目
 */
public class Solution1705 {
    public static void main(String[] args) {
        Solution1705 obj = new Solution1705();
        System.out.println(obj.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0, d = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        while (d < days.length || !pq.isEmpty()) {
            //添加新结出的苹果
            if (d < days.length && days[d] > 0) {
                pq.offer(new int[]{days[d] + d, apples[d]});
            }
            //删除腐烂的苹果或者吃完的苹果
            while (!pq.isEmpty() && (pq.peek()[0] <= d || pq.peek()[1] == 0)) {
                pq.poll();
            }
            //吃苹果，一天最多吃一个
            if (!pq.isEmpty()){
                ans++;
                pq.peek()[1]--;
            }
            d++;
        }
        return ans;
    }

}