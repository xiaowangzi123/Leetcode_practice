package com.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 构造矩形
 */
public class Solution0492 {
    public static void main(String[] args) {
        Solution0492 obj = new Solution0492();
        System.out.println(Arrays.toString(obj.constructRectangle(8)));
        System.out.println(Arrays.toString(obj.constructRectangle2(7)));
    }

    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        while (area % l != 0) {
            l--;
        }
        return new int[]{area / l, l};
    }

    public int[] constructRectangle2(int area) {
        int len = (int) Math.sqrt(area);
        int l = len, w = len;
        while (w > 0 && l <= area) {
            if (l * w == area) {
                return new int[]{l, w};
            } else if (l * w < area) {
                l++;
            } else {
                w--;
            }
        }
        return new int[]{l, w};
    }

}