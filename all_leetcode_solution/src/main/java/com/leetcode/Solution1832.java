package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :判断句子是否为全字母句
 */
public class Solution1832 {
    public static void main(String[] args) {
        Solution1832 obj = new Solution1832();
        System.out.println(obj.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(obj.checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(obj.checkIfPangram("leetcode"));
        System.out.println(obj.checkIfPangram2("leetcode"));
        System.out.println("-----------------------------");
    }

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 26;
    }

    public boolean checkIfPangram2(String sentence) {
        int[] count = new int[26];
        for (char ch : sentence.toCharArray()) {
            count[ch-'a']++;
        }

        for (int i=0;i<26;i++){
            if (count[i]==0){
                return false;
            }
        }
        return true;
    }
}