package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :两个列表的最小索引总和
 */
public class Solution0599 {
    public static void main(String[] args) {
        Solution0599 obj = new Solution0599();
//        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] s2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = {"KFC", "Shogun", "Burger King"};

        System.out.println(Arrays.toString(obj.findRestaurant(s1, s2)));
        System.out.println(Arrays.toString(obj.findRestaurant2(s1, s2)));
    }

    //不能满足最少的索引和
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        Collections.addAll(set1, list1);
        for (String str : list2) {
            if (set1.contains(str)) {
                ans.add(str);
            }
        }
        return ans.toArray(new String[0]);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int temp = map1.get(list2[i]) + i;
                if (temp < count) {
                    count = temp;
                    ans.clear();
                    ans.add(list2[i]);
                } else if (temp == count) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}