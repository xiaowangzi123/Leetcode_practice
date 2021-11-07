package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 猜数字游戏
 */
public class Solution0299 {
    public static void main(String[] args) {
        Solution0299 obj = new Solution0299();
        System.out.println(obj.getHint("1807", "7810"));
    }

    public String getHint(String secret, String guess) {
        int bulls = 0, cow = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                cnt1[secret.charAt(i) - '0']++;
                cnt2[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(cnt1[i], cnt2[i]);
        }
        return bulls + "A" + cow + "B";
    }
}