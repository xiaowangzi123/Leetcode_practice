package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 按键持续时间最长的键
 */
public class Solution1629 {
    public static void main(String[] args) {
        Solution1629 obj = new Solution1629();
        int[] releaseTimes = {9, 29, 49, 50};
        String keysPressed = "cbcd";
        System.out.println(obj.slowestKey(releaseTimes, keysPressed));

        System.out.println((int) ' ');
        System.out.println((int) 'a');
        System.out.println('a' > ' ');
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0], time = 0;
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max || (time == max && keysPressed.charAt(i) > ans)) {
                max = time;
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}