package com.leetcode.s0201_0300;

/**
 * Nim 游戏
 */
public class Solution0292 {
    public static void main(String[] args) {
        Solution0292 obj = new Solution0292();
        System.out.println(obj.canWinNim(5));
    }
    /**
     * n=1,拿走一块，赢
     * n=2,拿走两块，赢
     * n=3，拿走三块，赢
     * n=4，无论拿走几块，对方都可以拿完，输
     *
     * 如果石头堆中只有一块、两块、或是三块石头，那么在你的回合，你就可以把全部石子拿走，从而在游戏中取胜；
     * 如果堆中恰好有四块石头，你就会失败。
     * 因为在这种情况下不管你取走多少石头，总会为你的对手留下几块，他可以将剩余的石头全部取完，从而他可以在游戏中打败你。
     * 因此，要想获胜，在你的回合中，必须避免石头堆中的石子数为 4 的情况。
     *
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}