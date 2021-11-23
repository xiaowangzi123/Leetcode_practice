package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/22
 * @description : 删除一个元素使数组严格递增
 */
public class Solution1909 {
    public static void main(String[] args) {
        Solution1909 obj = new Solution1909();
        System.out.println(obj.canBeIncreasing3(new int[]{2, 3, 1, 2}));
        System.out.println(obj.canBeIncreasing3(new int[]{9, 1, 2, 3, 4}));
        System.out.println(obj.canBeIncreasing3(new int[]{1, 2, 3, 10, 5}));
        System.out.println(obj.canBeIncreasing2(new int[]{10, 1, 2, 5, 7}));
        System.out.println(obj.canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(obj.canBeIncreasing2(new int[]{1, 1, 1}));

    }

    public boolean canBeIncreasing(int[] nums) {
        int count = 0, n = nums.length;
        int max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= max) {
                count++;
                if (count > 1) {
                    break;
                }
            } else {
                max = nums[i];
            }
        }
        if (count <= 1) {
            return true;
        }
        count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= min) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                min = nums[i];
            }
        }
        return true;
    }

    /**
     * 遍历数组，找到第一个递减的元素对，有nums[k]>=nums[k+1]
     * 1.如果k=0,说明较大数出现在第一位，删除第一位满足条件
     * 2.如果nums[k+1]>nums[k-1]，说明nums[k]为峰值，删除k位
     * 3.如果k=n-2,说明较大数在n-2,较小数在最后一位，删除最后一位满足条件
     * 4.如果nums[k]<nums[k+2],表明nums[k+1]为低谷值，删除k+1位置元素
     * 以上四种情况只能出现一次，出现第二次时则不满足条件，直接返回false
     */
    public boolean canBeIncreasing2(int[] nums) {
        boolean flag = true;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                if (flag) {
                    if (i == 1 || nums[i] > nums[i - 2]) {
                        flag = false;
                    } else if (i == n - 1 || nums[i + 1] > nums[i - 1]) {
                        flag = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 遍历数组，找到第一个递减的元素对，有nums[k]>=nums[k+1]
     * 1.如果nums[k-1]>=nums[k+1]时，表明nums[k+1]小于前两个元素，将nums[k]赋值给nums[k+1]后，相当于删除了nums[k+1]，继续后续遍历
     * 2.如果nums[k-1]<nums[k+1],将nums[k-1]赋值给nums[k]，相当于删除了nums[k]
     * 以上情况只能出现一次
     */
    public boolean canBeIncreasing3(int[] nums) {
        int count = 0;
        for (int k = 0; k < nums.length - 1 && count <= 1; k++) {
            if (nums[k + 1] > nums[k]) {
                continue;
            }
            count++;
            if (k > 0 && nums[k + 1] <= nums[k - 1]) {
                nums[k + 1] = nums[k];
            } /*else {
                nums[k] = nums[k - 1];
            }*/
        }
        return count <= 1;
    }

    public boolean canBeIncreasing33(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 1 > 0 && nums[i] <= nums[i - 2]) {
                nums[i] = nums[i - 1];
            } /*else {
                nums[i - 1] = nums[i];
            }*/
        }
        return count <= 1;
    }
}