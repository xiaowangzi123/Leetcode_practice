package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/28
 * @description : 重新排序得到 2 的幂
 */
public class Solution0869 {
    public static void main(String[] args) {
        Solution0869 obj = new Solution0869();
        System.out.println(obj.reorderedPowerOf2(10));
        System.out.println(obj.reorderedPowerOf22(16));
        Set<String> set = new HashSet<>();
        char[] ch1 = {'1', '2'};
        char[] ch2 = {'3', '2'};
        char[] ch3 = {'2', '3'};
        set.add(new String(ch1));
        set.add(new String(ch2));
        System.out.println(set.contains(new String(ch3)));

    }

    /**
     * 首先找出2的n次幂结果的所有值
     * 比较结果中与n的长度
     */
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= Math.pow(10, 9); i *= 2) {
            StringBuilder sb = new StringBuilder();
            int num = i;
            while (num > 0) {
                sb.append(num % 10);
                num /= 10;
            }
            set.add(sb.reverse().toString());
        }

        for (String s : set) {
            String temp = String.valueOf(n);
            char[] chs = temp.toCharArray();
            Arrays.sort(chs);
            if (s.length() == chs.length) {
                boolean flag = true;
                char[] sChar = s.toCharArray();
                Arrays.sort(sChar);
                for (int i = 0; i < sChar.length; i++) {
                    if (sChar[i] != chs[i]) {
                        flag = false;
                    }
                }
                if (flag) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean reorderedPowerOf22(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= Math.pow(10, 9); i *= 2) {
            set.add(countNum(i));
        }
        return set.contains(countNum(n));
    }

    public String countNum(int num) {
        char[] count = new char[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return new String(count);
    }
}