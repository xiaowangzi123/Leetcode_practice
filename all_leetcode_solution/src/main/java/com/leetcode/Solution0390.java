package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wyq
 * @create time: 2022/1/2
 * @description: 消除游戏
 */
public class Solution0390 {
    public static void main(String[] args) {
        Solution0390 obj = new Solution0390();
        System.out.println(obj.lastRemaining2(11));
        System.out.println(obj.lastRemaining2(9));
    }

    //超时
    public int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean flag = true;
        while (list.size() > 1) {
            if (flag) {
                for (int i = 0; list.size() > 1 && i < list.size(); i++) {
                    list.remove(i);
                }
                flag = false;
            } else {
                for (int i = list.size() - 1; list.size() > 1 && i >= 0; i -= 2) {
                    list.remove(i);
                }
                flag = true;
            }
        }
        return list.get(0);
    }

    public int lastRemaining2(int n) {
        int num = n;
        int l = 1;
        int r = n;
        boolean flag = true;
        int lift = 1;
        while (num > 2) {
            if (flag) {
                if (num % 2 == 1) {
                    r -= lift;
                }
                l += lift;
                flag = false;
            } else {
                if (num % 2 == 1) {
                    l += lift;
                }
                r -= lift;
                flag = true;
            }
            num /= 2;
            lift *= 2;
        }
        return num == 2 && flag ? r : l;
    }
}
