package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/27
 * @description : 山羊拉丁文
 */
public class Solution0825 {
    public static void main(String[] args) {
        Solution0825 obj = new Solution0825();
        String s = "I speak Goat Latin";
        System.out.println(obj.numFriendRequests(new int[]{16, 16}));
        System.out.println(obj.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(obj.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    /**
     * x向y发送好友请求，满足以下条件
     * 0.5*[x]+7<a[y]<=a[x]
     */
    public int numFriendRequests(int[] ages) {
        int ans = 0, n = ages.length;
        int l = 0, r = 0;
        Arrays.sort(ages);
        for (int a : ages) {
            if (a < 15) {
                continue;
            }

            while (ages[l] <= 0.5 * a + 7) {
                l++;
            }
            while (r + 1 < n && ages[r + 1] <= a) {
                r++;
            }
            ans += r - l;
        }
        return ans;
    }
}