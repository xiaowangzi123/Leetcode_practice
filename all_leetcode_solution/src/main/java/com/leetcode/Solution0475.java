package com.leetcode;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2021/12/20
 * @description: 供暖器
 */
public class Solution0475 {
    public static void main(String[] args) {
        Solution0475 obj = new Solution0475();
        System.out.println(obj.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(obj.findRadius2(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(obj.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(obj.findRadius2(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(obj.findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(obj.findRadius2(new int[]{1, 5}, new int[]{2}));

        System.out.println(obj.findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923}, new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
        System.out.println(obj.findRadius2(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923}, new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));


        System.out.println(obj.findRadius(new int[]{617819336, 399125485, 156091745, 356425228}, new int[]{585640194, 937186357}));
        System.out.println(obj.findRadius2(new int[]{617819336, 399125485, 156091745, 356425228}, new int[]{585640194, 937186357}));
        System.out.println("-------------------------");
//        System.out.println(obj.minDistance(new int[]{1, 5, 8, 10}, 1));
        System.out.println(obj.minDistance(new int[]{1, 5, 8, 10}, 2));
        System.out.println(obj.minDistance(new int[]{1, 5, 8, 10}, 9));
        System.out.println(obj.minDistance(new int[]{1, 5, 8, 10}, 11));
    }

    /**
     * houses房屋位子，heaters取暖器位子
     * 算最小的加热半径
     * 1.首先算出每一个房屋的所需要的最小加热半径
     * 2.取这些所有加热半径中的最大值，即为满足答案的最小加热半径
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                max = Math.min(max, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    /**
     * 对于每个房屋，要么用前面的暖气，要么用后面的暖气
     */
    public int findRadius2(int[] houses, int[] heaters) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int h : houses) {
            int temp = minDistance(heaters, h);
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    //二分查找选出第一个大于目标值的位置
    public int minDistance(int[] arr, int h) {
        if (arr.length < 2) {
            return Math.abs(arr[0] - h);
        } else {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > h) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (r < 1) {
                return Math.abs(arr[0] - h);
            } else if (r == arr.length - 1) {
                return Math.abs(arr[r] - h);
            } else {
                return Math.min(h - arr[r], arr[r + 1] - h);
            }
        }

    }
}