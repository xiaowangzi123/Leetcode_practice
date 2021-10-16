package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :种花问题
 */
public class Solution0605 {
    public static void main(String[] args) {
        Solution0605 obj = new Solution0605();
//        int[] flowerbed = {1, 0, 0, 0, 1};
        int[] flowerbed = {0, 0, 1, 0, 0};
        int n = 1;
        System.out.println(obj.canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /**
         * count表示连续有多少0
         * 初始化count为1，处理左边界首位为0，则统计为2；首位为1时，重新复制count为0
         */
        int count = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                n--;
                count = 1;
            }
        }
        //处理右边界有两个0时，可以继续种
        if (count == 2) {
            n--;
        }
        return n <= 0;
    }
}