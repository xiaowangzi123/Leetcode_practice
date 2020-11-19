package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        String address = "255.100.50.0";

        System.out.println(address.replace(".", "[.]"));
        System.out.println(address.replaceAll("\\.", "[.]"));
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}