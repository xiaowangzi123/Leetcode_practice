package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author: wyq
 * @create time: 2021/11/22
 * @description: 打乱数组
 */
public class Solution {
    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println("-------------");
    }

    int[] arr;
    int[] original;

    public Solution(int[] nums) {
        this.arr = nums;
        this.original = nums.clone();
    }

    public int[] reset() {
        System.arraycopy(original, 0, arr, 0, arr.length);
        return arr;
    }

    /**
     * 参考Collections.shuffle();
     */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = i + random.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public int[] shuffle2() {
        Random random = new Random();
        for (int i = 1; i <= arr.length; i++) {
            int j = random.nextInt(i);
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
