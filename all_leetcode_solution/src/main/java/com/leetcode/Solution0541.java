package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/25
 * @description : 反转字符串 II
 */
public class Solution0541 {
    public static void main(String[] args) {
        Solution0541 obj = new Solution0541();
        String s = "abcdefg";
        System.out.println(obj.reverseStr(s, 2));
        System.out.println(s.substring(6,7));

    }

    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int n = s.length(), j = 0;
        while (j <= n / k) {
            if (j % 2 == 0) {
                StringBuilder temp = new StringBuilder(s.substring(j * k, Math.min(j * k + k, n)));
                ans.append(temp.reverse());
            } else {
                ans.append(s, j * k, Math.min(j * k + k, n));
            }
            j++;
        }
        return ans.toString();
    }

    public String reverseStr2(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}