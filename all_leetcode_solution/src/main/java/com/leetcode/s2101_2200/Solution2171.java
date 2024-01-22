package com.leetcode.s2101_2200;


import java.util.Arrays;

/**
 * 拿出最少数目的魔法豆
 */
public class Solution2171 {

    public static void main(String[] args) {
        Solution2171 solution = new Solution2171();
        int[] beans = new int[]{4, 1, 6, 5};
        int[] beans2 = new int[]{2, 10, 3, 2};
        System.out.println(solution.minimumRemoval(beans));
        System.out.println(solution.minimumRemoval(beans2));
    }

    /**
     * 可以把这个题目中数组的值，看作是木板的长度，怎么最大限度保留木板(丢掉的模板最少)
     * 长度从低到高排序
     * 一定是按照某一个木板的值保留木板的长度
     * 只需要对数组排序以后，枚举每个高度，统计这个高度下的矩形，以及让总高度减去这个矩形面积的值，
     * 取最小的就是我们的答案了。
     */
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        //如果数量值比较大，超过int范围会报错
//        long sum = Arrays.stream(beans).sum();
        long sum = Arrays.stream(beans).asLongStream().sum();
        Arrays.sort(beans);
        long count = sum;
        for (int i = 0; i < n; i++) {
            count = Math.min(count, sum - (long) beans[i] * (n - i));
        }
        return count;
    }
}
