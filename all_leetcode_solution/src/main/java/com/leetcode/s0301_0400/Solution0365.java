package com.leetcode.s0301_0400;

/**
 * 水壶问题
 */
public class Solution0365 {
    public static void main(String[] args) {
        Solution0365 obj = new Solution0365();
        System.out.println(obj.canMeasureWater(3, 5, 4));
        System.out.println(obj.canMeasureWater(2, 6, 5));
        System.out.println(obj.canMeasureWater(1, 2, 3));


    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return jug1Capacity == jug2Capacity || jug2Capacity == targetCapacity;
        }
        int a = gcd(jug1Capacity, jug2Capacity);
        return targetCapacity % a == 0;
    }

    private int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x % y);
    }
}