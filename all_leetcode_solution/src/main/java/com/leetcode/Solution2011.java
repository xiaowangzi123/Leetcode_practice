package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 执行操作后的变量值
 */
public class Solution2011 {
    public static void main(String[] args) {
        Solution2011 obj = new Solution2011();
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(obj.finalValueAfterOperations(operations));
        System.out.println(obj.finalValueAfterOperations2(operations));
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String s : operations) {
            if (s.contains("+")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

    //比上面快
    public int finalValueAfterOperations2(String[] operations) {
        int ans = 0;
        for (String s : operations) {
            if (s.charAt(1)=='+') {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}