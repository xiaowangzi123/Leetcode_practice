package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/1
 * @description :set集合应用
 */
public class Solution1436 {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("b");
        path.add("c");
        paths.add(path);

        List<String> path2 = new ArrayList<>();
        path2.add("d");
        path2.add("b");
        paths.add(path2);

        List<String> path3 = new ArrayList<>();
        path3.add("c");
        path3.add("a");
        paths.add(path3);
        System.out.println(paths);

        Solution1436 obj = new Solution1436();
        System.out.println(obj.destCity(paths));
    }

    /**
     * 终点站只有一个，中途站都是成对出现的
     * 用set集合存储所有的出发站
     * 遍历所有的到达站，没有出现过的就是终点站
     */
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}