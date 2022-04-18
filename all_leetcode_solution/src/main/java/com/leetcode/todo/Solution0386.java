package com.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/4/18
 * @description: TODO
 * 386. 字典序排数
 */
public class Solution0386 {
    public static void main(String[] args) {
        Solution0386 obj = new Solution0386();
        System.out.println(obj.lexicalOrder(13));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

}