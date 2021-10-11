package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0914 {
    public static void main(String[] args) {
        Solution0914 obj = new Solution0914();
//        int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] arr = {1, 2, 3, 4, 4, 3, 1};

        System.out.println(obj.hasGroupsSizeX(arr));
        System.out.println("-------------------");

        System.out.println(obj.gongYueShu(9, 6));
        System.out.println(obj.gongYueShu2(9, 6));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = deck.length;
        for (int x = 2; x <= n; x++) {
            //执行所有的循环n % x都不为0，返回false
            if (n % x == 0) {
                boolean flag = true;
                for (int value : map.values()) {
                    //元素的个数无法分组，返回false；
                    if (value % x != 0) {
                        //此处false不能返回，需要进行下一循环
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }

        }
        return false;
    }


    public boolean hasGroupsSizeX2(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }

    /**
     * 更相减损数
     * 比较a,b大小，大数减小数，把差赋给大数，
     * 再次比较，相减，赋值，直到a,b相等，
     * 即为最大约数
     */
    public int gongYueShu(int a, int b) {
        while (a != b) {
            a = a > b ? a - b : a;
            b = b > a ? b - a : b;
        }
        return a;
    }

    /**
     * 辗转相除法
     * a对b取余，b赋值给a 余数赋值给b，直到 b == 0
     */
    public int gongYueShu2(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}