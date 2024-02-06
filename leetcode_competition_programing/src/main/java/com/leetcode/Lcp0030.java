package com.leetcode;

import java.util.PriorityQueue;

/**
 * 数字游戏
 */
public class Lcp0030 {
    public static void main(String[] args) {
        Lcp0030 obj = new Lcp0030();
        int[] nums = {100, 100, 100, -250, -60, -140, -50, -50, 100, 150};
        System.out.println(obj.magicTower(nums));
        System.out.println(obj.magicTower(new int[]{-200, -300, 400, 0}));
    }

    /**
     * TODO
     */
    public int magicTower(int[] nums) {
        long sum = 1L;
        //一次遍历确定是否能够访问全部房间，也可在调整过程中判断
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum <= 0) {
            return -1;
        }
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //调整次数
        int ans = 0;
        //血量
        sum = 1L;
        for (int num : nums) {
            sum += num;
            if (num < 0) {
                //扣除的血量值加入最小堆，作为调整备用
                minHeap.offer(num);
                //因为sum之前为正，所以最多取1次（至少可取出刚加入的扣除量）即可恢复正值
                if (sum <= 0) {
                    //当前血量为负数，取出之前遇到扣除的最大血量（即负数最小值）进行调整
                    sum -= minHeap.poll();
                    ans++;
                }
            }
        }
        return ans;
    }
}
