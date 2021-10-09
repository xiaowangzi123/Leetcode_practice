package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0387 {
    public static void main(String[] args) {
        Solution0387 obj = new Solution0387();
        String s = "leetcode";
        System.out.println(obj.firstUniqChar(s));
        System.out.println(obj.firstUniqChar2(s));

    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i=0;i<n;i++){
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

}