package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 统计匹配检索规则的物品数量
 */
public class Solution1773 {
    public static void main(String[] args) {
        Solution1773 obj = new Solution1773();
        List<List<String>> items = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("phone");
        item.add("blue");
        item.add("pixel");
        items.add(item);

        item = new ArrayList<>();
        item.add("computer");
        item.add("silver");
        item.add("lenovo");
        items.add(item);

        item = new ArrayList<>();
        item.add("phone");
        item.add("gold");
        item.add("iphone");
        items.add(item);
        System.out.println(obj.countMatches(items, "color", "silver"));
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0, i = getRuleKeyIndex(ruleKey);
        for (List<String> list : items) {
            String temp = list.get(i);
            if (ruleValue.equals(temp)) {
                count++;
            }
        }
        return count;
    }

    public int getRuleKeyIndex(String s) {
        if ("type".equals(s)) {
            return 0;
        } else if ("color".equals(s)) {
            return 1;
        } else {
            return 2;
        }
    }
}