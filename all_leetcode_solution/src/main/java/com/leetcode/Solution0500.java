package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/10/09
 * @description ：键盘行
 */
public class Solution0500 {
    public static void main(String[] args) {
        Solution0500 obj = new Solution0500();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(obj.findWords(words)));
        System.out.println(Arrays.toString(obj.findWords2(words)));
        System.out.println(Arrays.toString(obj.findWords3(words)));

        String st = "hello";
        char ch = 'h';
        System.out.println(st.contains(ch + ""));
        System.out.println(st.contains(st.charAt(0) + ""));

        StringBuilder sb = new StringBuilder("qwertyuiopQWERTYUIOP");
        System.out.println(sb.indexOf(String.valueOf(ch)));

        System.out.println("-----------------");
        List<String> list = new ArrayList<>(Arrays.asList("abc", "cdf", "wld"));
        System.out.println(list);
        System.out.println(list.subList(0, 2));

        String[] strd = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strd));

        List<String> list2 = new ArrayList<>(3);
        list2.add("123");
        list2.add("678");
        list2.add("345");
        String[] strf = list2.toArray(new String[0]);
        System.out.println(Arrays.toString(strf));
        System.out.println("-----------------");

        boolean a1 = false, a2 = true, a3 = true;
        if ((a1 && a2) ||(a1 && a3)|| (a3 && a2)) {
            System.out.println("if执行");
        }
    }


    public String[] findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";

        int n = words.length, index = 0;
        String[] ans = new String[n];
        for (String s : words) {
            int n1 = 0, n2 = 0, n3 = 0, l = s.length();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (s1.contains(ch + "")) {
                    n1++;
                } else if (s2.contains(String.valueOf(ch))) {
                    n2++;
                } else {
                    n3++;
                }
            }
            if (n1 == l || n2 == l || n3 == l) {
                ans[index++] = s;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

    public String[] findWords2(String[] words) {
        StringBuilder s1 = new StringBuilder("qwertyuiopQWERTYUIOP");
        StringBuilder s2 = new StringBuilder("asdfghjklASDFGHJKL");

        List<String> ans = new ArrayList<>();
        for (String s : words) {
            int n1 = 0, n2 = 0, n3 = 0, l = s.length();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (s1.indexOf(String.valueOf(ch)) != -1) {
                    n1++;
                } else if (s2.indexOf(String.valueOf(ch)) != -1) {
                    n2++;
                } else {
                    n3++;
                }
            }
            if (n1 == l || n2 == l || n3 == l) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }

    //效率比上面两个低很多
    public String[] findWords3(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";

        List<String> ans = new ArrayList<>();
        for (String s : words) {
            boolean b1 = false, b2 = false, b3 = false;
            for (int i = 0; i < s.length(); i++) {
                //如果单词属于同一行，b1,b2,b3在循环结束只有一个为true；如果有两个或者三个为true，结束当前循环
                if ((b1 && b2) ||(b1 && b3)|| (b2 && b3)) {
                    break;
                }
                char ch = s.charAt(i);
                if (s1.contains(ch + "")) {
                    b1 = true;
                } else if (s2.contains(String.valueOf(ch))) {
                    b2 = true;
                } else {
                    b3 = true;
                }
            }
            if (!((b1 && b2) ||(b1 && b3)|| (b2 && b3))) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }
}