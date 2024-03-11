package com.leetcode.s0201_0300;

/**
 * 猜数字游戏
 */
public class Solution0299 {
    public static void main(String[] args) {
        Solution0299 obj = new Solution0299();
        System.out.println(obj.getHint("1807", "7810"));
    }

    /**
     * 对于公牛，需要满足数字和确切位置都猜对。
     * 我们可以遍历 secret和 guess，统计满足 secret[i]=guess[i]的下标个数，即为公牛的个数。
     *
     */
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