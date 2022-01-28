package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2022/1/28
 * @description: 游戏中弱角色的数量
 */
public class Solution1996 {
    public static void main(String[] args) {
        Solution1996 obj = new Solution1996();
        System.out.println(obj.numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(obj.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
        System.out.println(obj.numberOfWeakCharacters(new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}));
    }


    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0, n = properties.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}