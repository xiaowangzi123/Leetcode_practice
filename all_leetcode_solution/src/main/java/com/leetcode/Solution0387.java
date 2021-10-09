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
        String ransomNote = "a", magazine = "b";
        System.out.println(obj.canConstruct(ransomNote, magazine));
        System.out.println(obj.canConstruct2(ransomNote, magazine));

        System.out.println("---------------");
        StringBuilder s1 = new StringBuilder("abcdefghijklmn");
        System.out.println(s1.toString());
        int n = s1.indexOf("d");
        //        s1.replace(0, 1, "A");
        System.out.println(n);
        s1.delete(3,4);
        System.out.println(s1);
        System.out.println(s1.indexOf("o"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length(), n2 = magazine.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < n1; i++) {
            char ch = ransomNote.charAt(i);
            int n = map.getOrDefault(ch, 0);
            if (n > 0) {
                n--;
                if (n > 0) {
                    map.put(ch, n);
                } else {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        StringBuilder s2= new StringBuilder(magazine);
        for (int i=0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            int n = s2.indexOf(String.valueOf(ch));
            if (n==-1){
                return false;
            }else {
                s2.delete(n,n+1);
            }
        }
        return true;
    }

}