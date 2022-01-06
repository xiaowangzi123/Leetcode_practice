package com.leetcode;

import java.nio.file.Paths;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ： 简化路径
 */
public class Solution0071 {
    public static void main(String[] args) {
        Solution0071 obj = new Solution0071();
        System.out.println(obj.simplifyPath("/home/"));
        System.out.println(obj.simplifyPath("/../"));
        System.out.println(obj.simplifyPath("/home//foo/"));
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
    }

    public String simplifyPath(String path) {
        return Paths.get(path).normalize().toString();
    }

}