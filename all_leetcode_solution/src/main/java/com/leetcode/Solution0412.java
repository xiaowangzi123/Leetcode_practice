package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :Fizz Buzz
 */
public class Solution0412 {
    public static void main(String[] args) {
        Solution0412 obj = new Solution0412();
        System.out.println(obj.fizzBuzz(15));
        System.out.println(obj.fizzBuzz2(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if ((i % 5 == 0)) {
                sb.append("Buzz");
            } else {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}