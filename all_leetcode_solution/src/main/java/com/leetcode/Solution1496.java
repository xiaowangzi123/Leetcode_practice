package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :通过翻转子数组使两个数组相等
 */
public class Solution1496 {
    public static void main(String[] args) {
        Solution1496 obj = new Solution1496();
//        String path = "NES";
//        String path = "NESWW";
        System.out.println(obj.isPathCrossing("NES"));
        System.out.println(obj.isPathCrossing("NESWW"));

        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append(-1);
        System.out.println(sb);
    }


    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("00");
        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {
            String st = "";
            switch (ch) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
                default:
                    break;
            }
            st = x + "" + y;
            if (!set.add(st)) {
                return true;
            } else {
                set.add(st);
            }
        }
        return false;
    }


}