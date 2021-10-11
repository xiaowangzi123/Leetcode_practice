package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0819 {
    public static void main(String[] args) {
        Solution0819 obj = new Solution0819();
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

//        String paragraph = "Bob!";
//        String[] banned = {"hit"};

//        String paragraph = "abc abc? abcd the jeff!";
//        String[] banned = {"abc", "abcd", "jeff"};

//        String paragraph = "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'";
//        String[] banned = {"m", "i", "s", "w", "y", "d", "q", "l", "a", "p", "n", "t", "u", "b", "o", "e", "f", "g", "c", "x"};

        String paragraph = "Bob";
        String[] banned = {};

        System.out.println(obj.mostCommonWord(paragraph, banned));


        System.out.println("------------分割字符串--------------------");
        //分割字符串(String)
        /*List<String> list = new ArrayList<>();
        String word = "";
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (Character.isLetter(ch)) {
                word += paragraph.charAt(i);
            }
            if ((i == paragraph.length() - 1 || !Character.isLetter(ch)) && word.length() > 0) {
                list.add(word);
                word = "";
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
*/

        int i = 0;
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        while (i < paragraph.length()) {
            char ch = paragraph.charAt(i);
            if (Character.isLetter(ch)) {
                word.append(ch);
            }
            if ((i == paragraph.length() - 1 || !Character.isLetter(ch)) && word.length() > 0) {
                list.add(word);
                word = new StringBuilder();
            }
            i++;
        }
        System.out.println(Arrays.toString(list.toArray()));


        System.out.println("------------正则--------------------");

        String regex = ",\\s+|\\s+|,|\\.|!|\\?";
//        String regex = "\\.|,|,\\s+|\\s+";
//        String regex = "([,][^(,\\\\s)])+";
        String[] strs = paragraph.split(regex);
        System.out.println(Arrays.toString(strs));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(banned.length);
        for (String str : banned) {
            banSet.add(str);
        }
        //分割字符串
        List<String> list = new ArrayList<>();
        String word = "";
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (Character.isLetter(ch)) {
                word += paragraph.charAt(i);
            }
            if ((i == paragraph.length() - 1 || !Character.isLetter(ch)) && word.length() > 0) {
                list.add(word);
                word = "";
            }
        }
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String para : list) {
            para = para.toLowerCase();
            if (para.length() != 0 && !banSet.contains(para)) {
                map.put(para, map.getOrDefault(para, 0) + 1);
                if (map.get(para) > count) {
                    ans = para;
                    count = map.get(para);
                }
            }
        }
        return ans;
    }


    //适合一般有规律的字符串，LeetCode不能通过
    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(banned.length);
        for (String str : banned) {
            banSet.add(str);
        }

        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        //分割字符串
        String regex = ",\\s+|\\s+|,|\\.";
        String[] paras = paragraph.split(regex);
        for (String para : paras) {
            para = para.toLowerCase();
            if (para.length() != 0 && !banSet.contains(para)) {
                map.put(para, map.getOrDefault(para, 0) + 1);
                if (map.get(para) > count) {
                    ans = para;
                    count = map.get(para);
                }
            }
        }
        return ans;
    }


}