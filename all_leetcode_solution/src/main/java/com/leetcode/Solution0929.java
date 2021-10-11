package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0929 {
    public static void main(String[] args) {
        Solution0929 obj = new Solution0929();
        String[] str = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        System.out.println(obj.numUniqueEmails(str));


        System.out.println("-------------------------");
        String s = "test.email+alex@leetcode.com";
        String[] s12 = s.split("@");
        System.out.println(Arrays.toString(s12));
        System.out.println(s12[0].indexOf("+"));
        System.out.println(s12[1].indexOf("+"));
        System.out.println(s12[0].substring(0, s12[0].indexOf("+")));
        s12[0] = s12[0].substring(0, s12[0].indexOf("+"));
        System.out.println(Arrays.toString(s12));
        System.out.println("-------------------------");

        StringBuilder sb = new StringBuilder("test.email+alex@leetcode.com");
        int index = sb.indexOf("+");
        int index2 = sb.indexOf("@");
        sb.replace(index, index2, "");
        System.out.println(sb);

        System.out.println("-------------------------");
        String s2 = "a.b.c.d";
        System.out.println(s2.replace(".", ""));

    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf("@");
            String site = email.substring(0, index);
            String name = email.substring(index);
            if (site.contains("+")) {
                site = site.substring(0, site.indexOf("+"));
            }
            site = site.replace(".", "");
            set.add(site + name);
        }

        return set.size();
    }
}