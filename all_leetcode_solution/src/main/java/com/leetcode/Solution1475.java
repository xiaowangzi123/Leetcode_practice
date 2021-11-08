package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 商品折扣后的最终价格
 */
public class Solution1475 {
    public static void main(String[] args) {
        Solution1475 obj = new Solution1475();
        int[] arr = {8, 4, 6, 2, 3};
//        System.out.println(Arrays.toString(obj.finalPrices(arr)));
//        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(obj.finalPrices(arr2)));
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[i] < prices[j]) {
                j++;
            }
            if (j < n) {
                prices[i] = prices[i] - prices[j];
            }
        }

        return prices;
    }
}