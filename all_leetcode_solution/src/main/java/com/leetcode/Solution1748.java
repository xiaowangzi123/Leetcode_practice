package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :唯一元素的和
 */
public class Solution1748 {
    public static void main(String[] args) {
        Solution1748 obj = new Solution1748();

        int lowLimit = 1, highLimit = 10;
        System.out.println(obj.countBalls(lowLimit, highLimit));
        System.out.println(obj.countBalls2(lowLimit, highLimit));
    }


    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = 0, k = i;
            while (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
        }
        return max;
    }

    /**
     * 1 <= lowLimit <= highLimit <= 10^5
     * 各位数相加最大值为99999的位数相加45,
     * 初始化数组46
     */
    public int countBalls2(int lowLimit, int highLimit) {
        int max = 0;
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = 0, k = i;
            while (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            count[temp]++;
            max = Math.max(count[temp], max);
        }

        return max;
    }
}