package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1128 {

    public static void main(String[] args) {
        Solution1128 obj = new Solution1128();
        int[][] arr = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(obj.numEquivDominoPairs(arr));


        int[] a = {3, 5}, b = {3, 5}, c = {5, 3};
        StringBuilder s1 = new StringBuilder(a[0] + "" + a[1]);
        StringBuilder s2 = new StringBuilder(b[0] + "" + b[1]);
        StringBuilder s3 = new StringBuilder(c[0] + "" + c[1]);
        System.out.println(s1.toString());
        System.out.println(s1.toString().equals(s2.toString()));
        System.out.println(s1.toString().equals(s3.reverse().toString()));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] count = new int[100];
        for (int[] a : dominoes) {
            Arrays.sort(a);
            int temp = a[0] * 10 + a[1];
            ans += count[temp];
            count[temp]++;
        }
        return ans;
    }

    //两层for循环超时
    public int numEquivDominoPairs2(int[][] dominoes) {
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (isEqualeNums(dominoes[i], dominoes[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isEqualeNums2(int[] a, int[] b) {
        if (a.length != 2 || b.length != 2) {
            return false;
        }
        if (a[0] == b[0] && a[1] == b[1]) {
            return true;
        }
        if (a[1] == b[0] && a[0] == b[1]) {
            return true;
        }
        return false;
    }

    public boolean isEqualeNums3(int[] a, int[] b) {
        StringBuilder s1 = new StringBuilder(a[0] + "" + a[1]);
        StringBuilder s2 = new StringBuilder(b[0] + "" + b[1]);
        if (s1.toString().equals(s2.toString()) || s1.toString().equals(s2.reverse().toString())) {
            return true;
        }
        return false;
    }

    public boolean isEqualeNums(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return a[0] * 10 + a[1] == b[0] * 10 + b[1];
    }
}