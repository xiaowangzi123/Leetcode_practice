package com.leetcode;

import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ： 简化路径
 */
public class Solution0071 {
    public static void main(String[] args) {
        Solution0071 obj = new Solution0071();
        System.out.println(obj.simplifyPath("/home//foo/"));
        System.out.println(obj.simplifyPath2("/home//foo/"));
        System.out.println(obj.simplifyPath2("/../"));
        System.out.println(obj.simplifyPath2("/home/"));
        System.out.println(obj.simplifyPath2("/..."));
        System.out.println(obj.simplifyPath2("/home//foo/"));
        System.out.println(obj.simplifyPath2("/a/./b/../../c/"));
    }

    public String simplifyPath(String path) {
        return Paths.get(path).normalize().toString();
    }

    public String simplifyPath2(String path) {
        String[] names = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                if (name.length() > 0 && !".".equals(name)) {
                    deque.offer(name);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        if (deque.isEmpty()){
            ans.append("/");
        }
        while (!deque.isEmpty()){
            ans.append("/").append(deque.poll());
        }

        return ans.toString();
    }

}