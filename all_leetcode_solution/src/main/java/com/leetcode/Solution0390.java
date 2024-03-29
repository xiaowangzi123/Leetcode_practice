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
        System.out.println(obj.lastRemaining3(3));
        System.out.println(obj.lastRemaining3(11));
        System.out.println(obj.lastRemaining3(9));
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

    /**
     * 找左右两边的边界
     */
    public int lastRemaining2(int n) {
        int l = 1, r = n, step = 1;
        boolean flag = true;
        while (n > 2) {
            if (flag) {
                if (n % 2 == 1) {
                    r -= step;
                }
                l += step;
                flag = false;
            } else {
                if (n % 2 == 1) {
                    l += step;
                }
                r -= step;
                flag = true;
            }
            n /= 2;
            step *= 2;
        }
        return n == 2 && flag ? r : l;
    }

    public int lastRemaining3(int n) {
        int l = 1, step = 1;
        boolean flag = true;
        while (n > 1) {
            if (flag) {
                l += step;
                flag = false;
            } else {
                if (n % 2 == 1) {
                    l += step;
                }
                flag = true;
            }
            n /= 2;
            step *= 2;
        }
        return l;
    }
}
