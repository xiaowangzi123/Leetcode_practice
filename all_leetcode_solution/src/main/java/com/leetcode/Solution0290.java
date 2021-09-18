package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0290 {
    public static void main(String[] args) {
        Solution0290 obj = new Solution0290();
        String pattern = "dddd", str = "dog dog dog dog";
        System.out.println(obj.wordPattern(pattern, str));
    }

    /**
     * map键值对，
     * pattern.charAt(i)为键，s分割为字符数组str，srt[i]值为map值
     * pattern.charAt(i)键不存在，查看srt[i]作为值是否存在
     * 存在，表明不匹配，返回false；
     * 不存在，将其存入map
     * 2.pattern.charAt(i)键存在，表明已有匹配结果在map表中
     * 查看map表中其对应的值与srt[i]是否一致，
     * 不一致返回false；一致继续循环体
     *
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        if (pattern.length()!=str.length){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char sChar = pattern.charAt(i);
            String st = str[i];
            if (!map.containsKey(sChar)) {
                if (map.containsValue(st)) {
                    return false;
                }
                map.put(sChar, st);
            } else {
                if (!st.equals(map.get(sChar))) {
                    return false;
                }
            }
        }
        return true;
    }

}