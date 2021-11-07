package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 数组中第 K 个独一无二的字符串
 */
public class Solution2053 {
    public static void main(String[] args) {
        Solution2053 obj = new Solution2053();
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        System.out.println(obj.kthDistinct(arr, 2));
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if (entry.getValue()==1){
                k--;
                if (k==0){
                    return entry.getKey();
                }
            }
        }
        return "";
    }
}