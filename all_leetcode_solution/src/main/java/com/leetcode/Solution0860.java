package com.leetcode;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0860 {
    public static void main(String[] args) {
        Solution0860 obj = new Solution0860();
        int[] bills = {5, 5, 5, 10, 20, 20};
        System.out.println(obj.lemonadeChange(bills));
        System.out.println(obj.lemonadeChange2(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
                if (!map.containsKey(5) || map.get(5) <= 0) {
                    return false;
                }
                map.put(5, map.get(5) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else {
                if (map.containsKey(5) && map.get(5) > 0 && map.containsKey(10) && map.get(10) > 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                } else if (map.containsKey(5) && map.get(5) > 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int num : bills) {
            if (num == 5) {
                five++;
            } else if (num == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (num == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}