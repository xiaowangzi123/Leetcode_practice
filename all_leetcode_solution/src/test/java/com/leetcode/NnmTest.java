package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2022/1/18
 * @description :
 */
public class NnmTest {
    public static void main(String[] args) {
        NnmTest obj = new NnmTest();
        System.out.println(obj.getNum());
        System.out.println("-------------------");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 2, 3, 4, 7));
        System.out.println(obj.getMultDiff(list));
    }

    int num = 0;

    public int getNum() {
        boolean[] used = new boolean[10];
        dfs(new ArrayList<>(), used);
        return num;
    }

    public void dfs(List<Integer> list, boolean[] used) {
        if (list.size() >= 6) {
//            if (list.get(0) == 1 && getMult2(list) && getMult3(list) && getMult4(list) && getMult5(list) && getMult6(list)) {
            if (list.get(0) == 1 && getMultDiff(list)) {
                System.out.println(list);
                num++;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.add(i);
            dfs(list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    //这只能得到乘以n后，也是不同数字组成的六位数
    public boolean getMultDiff(List<Integer> list) {
        for (int j = 2; j <= 6; j++) {
            HashSet<Integer> set = new HashSet<>();
            int k = 0;
            for (int i = 5; i >= 0; i--) {
                int temp = list.get(i) * j + k;
                set.add(temp % 10);
                k = temp / 10;
            }
            if (set.size() < 6) {
                return false;
            }
        }
        return true;
    }

    public boolean getMultDiff2(List<Integer> list) {
        List<Integer> pre = list;
        for (int j = 2; j <= 6; j++) {
            HashSet<Integer> set = new HashSet<>();
            int k = 0;
            for (int i = 5; i >= 0; i--) {
                int temp = list.get(i) * j + k;
                set.add(temp % 10);
                k = temp / 10;
            }
            if (set.size() < 6) {
                return false;
            }
        }
        return true;
    }

    public boolean getMult2(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 5; i >= 0; i--) {
            int temp = list.get(i) * 2 + k;
            set.add(temp % 10);
            k = temp / 10;
        }
        return set.size() == 6;
    }

    public boolean getMult3(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 5; i >= 0; i--) {
            int temp = list.get(i) * 3 + k;
            set.add(temp % 10);
            k = temp / 10;
        }
        return set.size() == 6;
    }

    public boolean getMult4(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 5; i >= 0; i--) {
            int temp = list.get(i) * 4 + k;
            set.add(temp % 10);
            k = temp / 10;
        }
        return set.size() == 6;
    }

    public boolean getMult5(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 5; i >= 0; i--) {
            int temp = list.get(i) * 5 + k;
            set.add(temp % 10);
            k = temp / 10;
        }
        return set.size() == 6;
    }

    public boolean getMult6(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for (int i = 5; i >= 0; i--) {
            int temp = list.get(i) * 6 + k;
            set.add(temp % 10);
            k = temp / 10;
        }
        return set.size() == 6;
    }
}