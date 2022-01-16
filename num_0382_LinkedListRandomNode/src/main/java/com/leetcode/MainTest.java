package com.leetcode;

import java.util.Random;

/**
 * @author :wyq
 * @date ：Created in 2022/1/16
 * @description :
 */
public class MainTest {
    public static void main(String[] args) {
        Random random = new Random();
        int a = 0, b = 0;
        for (int i = 0; i < 1000; i++) {
            int temp = random.nextInt(2);
            if (temp == 0) {
                a++;
            } else if (temp == 1) {
                b++;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}