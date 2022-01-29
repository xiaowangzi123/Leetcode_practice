package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/1/29
 * @description: 救生艇
 */
public class Solution0881 {
    public static void main(String[] args) {
        Solution0881 obj = new Solution0881();
        System.out.println(obj.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(obj.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    /**
     * 一条船最多坐两个人
     * 体重最轻的人，如果不能和最重的乘坐一条船，那体重最重的人只能单独乘坐一条船
     * 最轻的与最重的和乘一条船，不超重
     */
    public int numRescueBoats(int[] people, int limit) {
        int count = 0, l = 0, r = people.length - 1;
        Arrays.sort(people);
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            count++;
        }

        return count;
    }
}