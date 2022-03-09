package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/9
 * @description: TODO
 * 得分最高的最小轮调
 */
public class Solution0798 {
    public static void main(String[] args) {
        Solution0798 obj = new Solution0798();
        System.out.println(obj.bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(obj.bestRotation(new int[]{1, 3, 0, 2, 4}));

    }

    //超时
    public int bestRotation(int[] nums) {
        int ans = 0;
        int k = 0, n = nums.length, max = 0;
        while (k < n) {
            if (k != 0) {
                for (int i = 0; i < n - 1; i++) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }

            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= i) {
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
                ans = k;
            }
            k++;
        }
        return ans;
    }

    public int bestRotation2(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }
        int bestIndex = 0;
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                bestIndex = i;
                maxScore = score;
            }
        }
        return bestIndex;
    }
}