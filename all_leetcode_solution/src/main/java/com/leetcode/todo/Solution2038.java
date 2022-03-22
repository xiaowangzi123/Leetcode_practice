package com.leetcode.todo;

/**
 * @author: wyq
 * @create time: 2022/3/20
 * @description : 如果相邻两个颜色均相同则删除当前颜色
 * TODO
 */
public class Solution2038 {
    public static void main(String[] args) {
        Solution2038 obj = new Solution2038();
        System.out.println(obj.winnerOfGame("AAABABB"));
        System.out.println(obj.winnerOfGame("AA"));
        System.out.println(obj.winnerOfGame("ABBBBBBBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        int[] freq = {0, 0};
        char cur = 'C';
        int cnt = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt += 1;
                if (cnt >= 3) {
                    freq[cur - 'A'] += 1;
                }
            }
        }
        return freq[0] > freq[1];
    }


    public boolean winnerOfGame2(String colors) {
        int len = colors.length();
        char[] chars = colors.toCharArray();
        int diff = 0;
        for (int i = 1; i < len - 1; i++) {
            if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') {
                diff++;
                continue;
            }
            if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') {
                diff--;
                continue;
            }
        }
        return diff > 0;

    }

}