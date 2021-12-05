package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/12/5
 * @description : 超级次方
 */
public class Solution0372 {
    public static void main(String[] args) {
        Solution0372 obj = new Solution0372();
        //665
//        System.out.println(obj.superPow(78267, new int[]{1, 7, 7, 4, 3, 1, 7, 0, 1, 4, 4}));
        System.out.println(obj.superPow2(78267, new int[]{1, 7, 7, 4, 3, 1, 7, 0, 1, 4, 4}));
        System.out.println(obj.superPow(2, new int[]{3}));
        System.out.println(obj.superPow2(2, new int[]{3}));
        System.out.println(obj.superPow(2, new int[]{1, 0}));
        System.out.println(obj.superPow2(2, new int[]{1, 0}));
        System.out.println(obj.superPow(2147483647, new int[]{2, 0, 0}));
        System.out.println(obj.superPow2(2147483647, new int[]{2, 0, 0}));

        System.out.println("---------------------");

        System.out.println(obj.getNumMod(2, 0));
        System.out.println(obj.pow(2, 0));
    }

    /**
     * 超时
     */
    public int superPow(int a, int[] b) {
        int n = b.length, ans = 1, temp = 1;
        a %= 1337;
        for (int i = n - 1; i >= 0; i--) {
            int m = b[i] * temp, pre = 1;
            for (int j = 0; j < m; j++) {
                pre = pre * a % 1337;
            }
            temp *= 10;
            ans = ans * pre % 1337;
        }
        return ans;
    }

    public int superPow2(int a, int[] b) {
        int n = b.length, ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = getNumMod(a, b[i]);
            int k = n - i - 1;
            while (k > 0) {
                temp = getNumMod(temp, 10);
                k--;
            }
            ans = ans * temp % 1337;
        }
        return ans;
    }

    public int getNumMod(int a, int b) {
        int ans = 1;
        a %= 1337;
        for (int i = 0; i < b; i++) {
            ans = (ans * a) % 1337;
        }
        return ans;
    }

    public int pow(int a, int b) {
        int ans = 1;
        a %= 1337;
        while (b-- > 0) {
            ans = ans * a % 1337;
        }
        return ans;
    }
}