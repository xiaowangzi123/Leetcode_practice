package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description : 1比特与2比特字符
 */
public class Solution0717 {
    public static void main(String[] args) {
        Solution0717 obj = new Solution0717();
//        int[] bits = {1, 0, 0};
        int[] bits = {1, 1, 1, 1, 0};
        System.out.println(obj.isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}