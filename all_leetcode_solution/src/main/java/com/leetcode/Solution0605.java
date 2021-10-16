package com.leetcode;

import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;

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
         * 判断count是否为3，是表明可以在中间种花；
         * 重复上面过程
         * 最后判断右边界count是否为2，是表明可以在最右边种花
         */
        int count = 1;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
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

    /**
     * 1.如果f[i]=1，表明此处有花，下一位置需要加2
     * 2.如果i=n-1,表明是最后一个位置，能够种植，下一位置加2；或者在i位置为0的同时第i+1为0，则能种花
     * 3.第i位为1，是第一种情况，i+1位置为0，是第二种情况；剩下的是第i位为0，i+1位置为1
     * 则i+2位置必为0，
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }
}