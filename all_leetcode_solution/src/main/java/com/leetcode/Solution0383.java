package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0383 {
    public static void main(String[] args) {
        Solution0383 obj = new Solution0383();
        String ransomNote = "a", magazine = "b";
        System.out.println(obj.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length(), n2 = magazine.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i=0;i<n1;i++){
            char ch = ransomNote.charAt(i);
            int n = map.getOrDefault(ch,0);
            if (n>0){
                n--;
                if (n>0){
                    map.put(ch, n);
                }else {
                    map.remove(ch);
                }
            }else {
                return false;
            }
        }
        return true;

    }

}