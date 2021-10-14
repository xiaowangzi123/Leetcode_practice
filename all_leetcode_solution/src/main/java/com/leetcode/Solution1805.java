package com.leetcode;

import com.sun.media.sound.EmergencySoundbank;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :符串中不同整数的数目
 */
public class Solution1805 {
    public static void main(String[] args) {
        Solution1805 obj = new Solution1805();
        System.out.println(obj.numDifferentIntegers("a1b01c001"));
        System.out.println(obj.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(obj.numDifferentIntegers("leet1234code234"));
        System.out.println(obj.numDifferentIntegers("gi851a851q8510v"));
        System.out.println("-----------------------------");


    }


    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        String[] str = word.split("[a-z]");
        for (String s : str) {
            if (!s.equals("")) {
                set.add(s.replaceFirst("^0*",""));
            }
        }
        return set.size();
    }
}