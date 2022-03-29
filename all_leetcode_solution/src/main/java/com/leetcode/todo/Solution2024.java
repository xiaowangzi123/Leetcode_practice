package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/20
 * @description : 2024. 考试的最大困扰度
 * TODO
 */
public class Solution2024 {
    public static void main(String[] args) {
        Solution2024 obj = new Solution2024();
        System.out.println(obj.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(obj.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(obj.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}