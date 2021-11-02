package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description : IP地址无效化
 */
public class Solution1108 {
    public static void main(String[] args) {
        Solution1108 obj = new Solution1108();
        String address = "255.100.50.0";
        System.out.println(obj.defangIPaddr(address));
        System.out.println("-------------------");

        System.out.println(address.replace(".", "[.]"));
        System.out.println(address.replaceAll("\\.", "[.]"));
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}