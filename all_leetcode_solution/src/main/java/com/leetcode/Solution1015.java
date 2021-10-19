package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : 将数组分成和相等的三个部分
 */
public class Solution1015 {
    public static void main(String[] args) {
        Solution1015 obj = new Solution1015();
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(obj.canThreePartsEqualSum(arr));
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        //数组和不能三等分，直接返回false
        if (sum % 3 != 0) {
            return false;
        }
        int sum1 = 0, index = 0;
        while (index < arr.length) {
            sum1 += arr[index];
            if (sum1 == sum / 3) {
                break;
            }
            index++;
        }

        index++;
        int sum2 = 0;
        while (index < arr.length - 1) {
            sum2 += arr[index];
            if (sum2 == sum / 3) {
                return true;
            }
            index++;
        }
        return false;
    }
}