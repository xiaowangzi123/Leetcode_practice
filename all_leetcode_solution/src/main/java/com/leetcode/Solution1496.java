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
        System.out.println(obj.isPathCrossing2("NES"));

        System.out.println(obj.isPathCrossing("NESWW"));
        System.out.println(obj.isPathCrossing2("NESWW"));

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


    public boolean isPathCrossing2(String path) {
        Set<Integer> vis = new HashSet<Integer>();

        int x = 0, y = 0;
        vis.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
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
            int hashValue = getHash(x, y);
            if (!vis.add(hashValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 因为y的取值范围在 [-10^4, 10^4]内，共有20001种可能性，
     * 所以下面哈希函数就不会造成冲突
     */
    public int getHash(int x, int y) {
        return x * 20001 + y;
    }
}