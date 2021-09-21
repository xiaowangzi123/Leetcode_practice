package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/21
 * @description：
 */
public class Solution0049 {
    public static void main(String[] args) {
        Solution0049 obj = new Solution0049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));

    }

    /**
     * 1.对string数组的每个元素strs排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            list.add(str);
            map.put(String.valueOf(chars), list);
        }

        return new ArrayList<>(map.values());
    }
}