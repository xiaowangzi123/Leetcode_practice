package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: wyq
 * @create time: 2021/11/27
 * @description: 随机翻转矩阵
 */
public class RandomMatrix {
    public static void main(String[] args) {
        RandomMatrix obj = new RandomMatrix(3, 1);
        System.out.println(Arrays.toString(obj.flip()));
        System.out.println(Arrays.toString(obj.flip()));
        System.out.println(Arrays.toString(obj.flip()));
        obj.reset();

    }

    Map<Integer, Integer> map = new HashMap<>();
    int m, n, total;
    Random rand = new Random();

    public RandomMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int r = rand.nextInt(total);
        total--;
        int idx = map.getOrDefault(r, r);
        // 将位置 r 对应的映射设置为位置 total 对应的映射
        map.put(r, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }


    public void reset() {
        total = m * n;
        map.clear();
    }
}
