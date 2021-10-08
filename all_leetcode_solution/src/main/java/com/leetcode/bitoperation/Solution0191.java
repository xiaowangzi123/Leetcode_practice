package com.leetcode.bitoperation;

/**
 * @author :wyq
 * @date ：Created in 2021/10/8
 * @description :
 */
public class Solution0191 {
    public static void main(String[] args) {
        Solution0191 obj = new Solution0191();
        System.out.println(obj.hammingWeight(5));
        System.out.println(obj.hammingWeight(5));
        System.out.println(obj.hammingWeight(5));
        
        System.out.println("----------------------");
        System.out.println(3&1);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

}