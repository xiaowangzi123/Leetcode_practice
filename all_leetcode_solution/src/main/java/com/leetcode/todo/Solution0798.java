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

    /**
     * 我们以A=[2,3,1,4,0]为例寻找规律:
     * A[0]=2移动到 2 号索引位置[4,0,2,3,1]其对应的K为3=(0-A[0]+5)%5
     * A[1]=3移动到 3 号索引位置[0,2,3,1,4]其对应的K为3=(1-A[1]+5)%5
     * A[2]=1移动到 1 号索引位置[3,1,4,0,2]其对应的K为1=(2-A[2]+5)%5
     * A[3]=4移动到 4 号索引位置[0,2,3,1,4]其对应的K为1=(3-A[3]+5)%5
     * A[4]=0移动到 0 号索引位置[0,2,3,1,4]其对应的K为3=(4-A[4]+5)%5
     *
     * 由此可以得出一个公式，将A[i]向左移动到下标A[A[i]]的位置需要K = (i - A[i] + N) % N
     * 并且我们发现，A[A[i]]是第一个A[i]能得分的位置，如果这时减小K，则A[i]继续得分，如果增大K则A[i]将不得分。
     * 如果我们能够刚好把所有A[i]都移动到A[A[i]]的位置，那么我们拿到的分数肯定的是最高的，但是这种情况几乎不可能。
     */
    public int beatRotation3(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i - nums[i] + 1 + n) % n] += 1;
        }

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1] - 1;
            if (arr[i] < arr[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}