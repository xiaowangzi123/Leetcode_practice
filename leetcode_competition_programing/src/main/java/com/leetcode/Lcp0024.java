package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Hello world!
 */
public class Lcp0024 {
    public static void main(String[] args) {
        Lcp0024 obj = new Lcp0024();
        int[] nums = {3,4,5,1,6,7};
        System.out.println(Arrays.toString(obj.numsGame(nums)));
    }

    public int[] numsGame(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] -= i;
        }

        int[] result = new int[n];
        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        long sum1 = nums[0], sum2 = 0;
        q1.offer((int) sum1);

        for (int i = 1; i < n; i++) {
            if (nums[i] <= q1.peek()) {
                q1.offer(nums[i]);
                sum1 += nums[i];
            } else {
                q2.offer(nums[i]);
                sum2 += nums[i];
            }

            if (q1.size() == q2.size() + 2) {
                int tmp = q1.poll();
                sum1 -= tmp;
                q2.offer(tmp);
                sum2 += tmp;
            }

            if (q1.size() + 1 == q2.size()) {
                int tmp = q2.poll();
                sum2 -= tmp;
                q1.offer(tmp);
                sum1 += tmp;
            }

            if (q1.size() == q2.size() + 1) {
                result[i] = (int) ((sum2 - sum1 + q1.peek()) % 1000000007);
            } else {
                result[i] = (int) ((sum2 - sum1) % 1000000007);
            }
        }
        return result;
    }
}
