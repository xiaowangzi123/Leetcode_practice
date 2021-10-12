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
    }


    //超时
    public int numEquivDominoPairs(int[][] dominoes) {
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

    public boolean isEqualeNums(int[] a, int[] b) {
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
}