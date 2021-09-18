package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/18
 * @description：
 */
public class Solution0205 {
    public static void main(String[] args) {
        Solution0205 obj = new Solution0205();
        String s = "cab", t = "aad";
        System.out.println(obj.isIsomorphic(s,t));
    }

    public boolean isIsomorphic(String s, String t) {
        //比较想对应的第i个字符出现的顺序的下标
        for (int i=0; i<s.length(); i++){
            if (s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}