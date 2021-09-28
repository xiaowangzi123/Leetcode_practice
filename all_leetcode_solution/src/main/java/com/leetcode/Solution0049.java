package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/21
 * @description ：字母异位词分组
 */
public class Solution0049 {
    public static void main(String[] args) {
        Solution0049 obj = new Solution0049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));

    }

    /**
     * HashMap应用
     * 1.对string数组的每个元素strs排序
     * 2.如果是字母异位词，则排序后是一样的。所以用排序后的元素作为key存储
     *       key值一样，表明是字母异位词，然后将未排序的元素str存储value
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