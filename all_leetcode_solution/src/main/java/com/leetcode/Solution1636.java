package com.leetcode;

import java.util.*;
import java.util.logging.Level;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :按照频率将数组升序排序
 */
public class Solution1636 {
    public static void main(String[] args) {
        Solution1636 obj = new Solution1636();
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(obj.frequencySort(nums)));
    }

    /**
     * 重写的public int compareTo(Student o){}
     * 返回值	含义
     * 1.负整数	当前对象的值 < 比较对象的值 ， 位置排在前
     * 2.零	    当前对象的值 = 比较对象的值 ， 位置不变
     * 3.正整数	当前对象的值 > 比较对象的值 ， 位置排在后
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(list, (x, y) -> {
            int i = map.get(x), j = map.get(y);
            if (i == j) {
                return y - x;
            } else {
                return i - j;
            }
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}