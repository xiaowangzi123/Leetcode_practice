package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0482 {
    public static void main(String[] args) {
        Solution0482 obj = new Solution0482();
        String s = "5F3Z-2e-9-w";
        System.out.println(obj.licenseKeyFormatting(s, 4));
        System.out.println(obj.licenseKeyFormatting2(s, 4));
        System.out.println(obj.licenseKeyFormatting3(s, 4));

        String s2 = "2-5g-3-J";
        System.out.println(obj.licenseKeyFormatting(s2, 2));
        System.out.println(obj.licenseKeyFormatting2(s2, 2));
        System.out.println(obj.licenseKeyFormatting3(s2, 2));

        String s3 = "--a-a-a-a--";
        System.out.println(obj.licenseKeyFormatting(s3, 2));
        System.out.println(obj.licenseKeyFormatting2(s3, 2));
        System.out.println(obj.licenseKeyFormatting3(s3, 2));

        int k = 2;
        StringBuilder sb = new StringBuilder("5F3Z2E9W");
        for (int i = sb.length() - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        System.out.println(sb);
    }

    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            count++;
            if (count % k == 0 && i != 0) {
                sb.append('-');
            }
        }
        return sb.reverse().toString();
    }

    //insert()方法
    public String licenseKeyFormatting2(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }

    public String licenseKeyFormatting3(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                ans.append(Character.toUpperCase(s.charAt(i)));
                count++;
                if (count % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}