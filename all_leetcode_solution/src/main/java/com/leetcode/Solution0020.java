package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0020 {
    public static void main(String[] args) {
        Solution0020 obj = new Solution0020();
        String s1 = "()[]{}";
        System.out.println(obj.isValid(s1));

        Map<String,Character> map = new HashMap<>();
        map.put("s", 's');
        System.out.println(map);
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }


        return false;
    }


}