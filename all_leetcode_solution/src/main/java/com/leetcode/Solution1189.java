package com.leetcode;

import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/12
 * @description :“气球” 的最大数量
 */
public class Solution1189 {
    public static void main(String[] args) {
        Solution1189 obj = new Solution1189();
//        String text = "nlaebolko";
        String text = "loonbalxballpoon";

        System.out.println(obj.maxNumberOfBalloons(text));
        System.out.println(obj.maxNumberOfBalloons2(text));
        System.out.println(obj.maxNumberOfBalloons3(text));

        System.out.println(Arrays.stream(new int[1]).count());
    }

    public int maxNumberOfBalloons(String text) {
        int count = Integer.MAX_VALUE;
        String balloon = "balloon";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : balloon.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> temp = new HashMap<>();
        for (char ch : text.toCharArray()) {
            temp.put(ch, temp.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            count = Math.min(count, temp.getOrDefault(entry.getKey(), 0) / entry.getValue());
        }
        return count;
    }

    public int maxNumberOfBalloons2(String text) {
        int min = Integer.MAX_VALUE;
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
                default:
                    break;
            }
        }
        min = Math.min(a, min);
        min = Math.min(b, min);
        min = Math.min(l / 2, min);
        min = Math.min(o / 2, min);
        min = Math.min(n, min);

        return min;
    }

    public int maxNumberOfBalloons3(String text) {
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> temp = new HashMap<>();
        for (char ch : text.toCharArray()) {
            temp.put(ch, temp.getOrDefault(ch, 0) + 1);
        }
        min = Math.min(min, temp.getOrDefault('a', 0));
        min = Math.min(min, temp.getOrDefault('b', 0));
        min = Math.min(min, temp.getOrDefault('l', 0) / 2);
        min = Math.min(min, temp.getOrDefault('o', 0) / 2);
        min = Math.min(min, temp.getOrDefault('n', 0));

        return min;
    }
}