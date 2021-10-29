package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : 只出现一次的数字 III
 */
public class Solution0260 {
    public static void main(String[] args) {
        Solution0260 obj = new Solution0260();
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(obj.singleNumber(arr)));
        System.out.println(Arrays.toString(obj.singleNumber2(arr)));
        System.out.println(Arrays.toString(obj.singleNumber3(arr)));
    }

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[i] = entry.getKey();
                i++;
            }
        }
        return ans;
    }

    public int[] singleNumber2(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        int i = 0;
        for (int s : set) {
            ans[i++] = s;
        }
        return ans;
    }

    /**
     * 1把所有的元素进行异或操作，最终得到一个异或值。因为是不同的两个数字a^b，所以这个值必定不为 0
     * 2. 位运算x&-x 取出 x 的二进制表示中最低位那个 1
     * 取异或值最后一个二进制位为 1 的数字作为 mask，如果是 1 则表示两个数字在这一位上不同。
     * 3.通过与这个mask进行与操作，如果为0的分为一个数组，为 1 的分为另一个数组。
     * 出现两次的元素一定被分在同一组
     * a和b一定被分在不同的组
     * 对这两个子问题分别进行全异或就可以得到两个解。也就是最终的数组了。
     */
    public int[] singleNumber3(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & (-xor);
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}