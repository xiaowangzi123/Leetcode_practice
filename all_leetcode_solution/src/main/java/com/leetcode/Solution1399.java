package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :统计最大组的数目
 */
public class Solution1399 {
    public static void main(String[] args) {
        Solution1399 obj = new Solution1399();
//        System.out.println(obj.countLargestGroup(2));
        System.out.println(obj.countLargestGroup(13));
        System.out.println(obj.countLargestGroup2(13));
        System.out.println(obj.countLargestGroup(15));
        System.out.println(obj.countLargestGroup2(15));

        System.out.println("-------------------------");

        System.out.println(10 / 10);

        System.out.println(obj.getSums(10));
        System.out.println(obj.getSums2(10));
        System.out.println(obj.getSums(78));
        System.out.println(obj.getSums2(78));


    }

    public int countLargestGroup(int n) {
        int max = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int temp = 0, k = i;
            while (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count++;
            }
        }
        return count;
    }


    /**
     * 1<=n<=10000
     * n的最大各个位数之和是9+9+9+9=36
     * 可以初始化一个37位数组。
     * 次方法有n大小的局限性
     */
    public int countLargestGroup2(int n) {
        int max = 0, cnt = 0;
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int temp = 0, k = i;
            while (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            count[temp]++;
            max = Math.max(count[temp], max);
        }
        for (int i:count){
            if (max==i){
                cnt++;
            }
        }
        return cnt;
    }


    public int getSums(int n) {
        int key = 0;
        while (n > 0) {
            key += n % 10;
            n /= 10;
        }
        return key;
    }

    public int getSums2(int n) {
        return n % 9;
    }
}