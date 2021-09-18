package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0205 {
    public static void main(String[] args) {
        Solution0205 obj = new Solution0205();
        String s = "ccb", t = "aad";
        System.out.println(obj.isIsomorphic(s, t));
        System.out.println(obj.isIsomorphic2(s, t));


        System.out.println("-------------------------");
        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'b');
        System.out.println(map.get('a'));
        System.out.println(map.get('b'));
    }

    public boolean isIsomorphic(String s, String t) {
        //比较想对应的第i个字符出现的顺序的下标
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        /**
         * map键值对，s.charAt(i)为键，t.charAt(i)为值
         * 1.s.charAt(i)键不存在，查看t.charAt(i)作为值是否存在
         *      存在，表明不匹配，返回false；
         *      不存在，将s.charAt(i)和t.charAt(i)存入map
         * 2.s.charAt(i)键存在，表明已有匹配结果在map表中
         *      查看map表中值与t.charAt(i)是否一致，
         *      不一致返回false；一致继续循环体
         */
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (!map.containsKey(sChar)) {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
            } else {
                if (tChar != map.get(sChar)) {
                    return false;
                }
            }
        }
        return true;
    }
}