package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0720 {
    public static void main(String[] args) {
        Solution0720 obj = new Solution0720();
//        String[] words = {"w", "wo", "wor", "worl", "world"};
//        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        //"latte"
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};

        //"yodn"
//        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(obj.longestWord(words));

        if ("latte".compareTo("cat")>0){
            System.out.println("latte");
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("latte");
        treeSet.add("cat");
        System.out.println(treeSet);
    }

    /**
     * 对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
     * 对字母排序后，第一个单词一定是共有的，后面只需在此基础上添加
     * 结果有几个的话，按字母排序取第一个
     */
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String ans = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                ans = word.length() > ans.length() ? word : ans;
                set.add(word);
            }
        }
        return ans;
    }
}