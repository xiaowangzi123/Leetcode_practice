package com.leetcode.s2801_2900;

import java.util.*;

/**
 * 使循环数组所有元素相等的最少秒数
 */
public class Solution2808 {
    public static void main(String[] args) {
        Solution2808 solution = new Solution2808();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(2, 1, 3, 3, 2));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(5, 5, 5, 5));
        List<Integer> nums4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9));
        System.out.println(solution.minimumSeconds2(nums1));
        System.out.println(solution.minimumSeconds2(nums2));
        System.out.println(solution.minimumSeconds2(nums3));
        System.out.println(solution.minimumSeconds2(nums4));
    }

    /**
     * 哈希表
     * 一秒数组中的每个元素都有三种操作：不变，变成左边的元素或者变成右边的元素。
     * 最终数组的元素一定是变成数组中的某个元素 x
     * 因此我们可以去统计每个元素扩散到整个数组的最少时间，然后去这些时间的最小值即为结果。
     * <p>
     * 考虑把数字 x「扩散」到其它位置，那么每一秒 x 都可以向左右扩散一位。
     * 多个相同数字 x 同时扩散，那么扩散完整个数组的耗时，就取决于相距最远的两个相邻的 x。
     * <p>
     * 统计所有相同数字的下标，记到一个哈希表 pos 中。
     * <p>
     * 如果数组中没有相同的数字，那么肯定的时间是最长的也就是n/2了
     * 既然可以改变左右2个相邻的数字，那么我们将相同元素的索引值放到一个链表里面，注意最后加一个n，这样就是环形链表了，
     */
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        /*for (int i = 0; i < nums.size(); i++){
            Integer num = nums.get(i);
            if (indexMap.containsKey(num)){
                List<Integer> list = indexMap.get(i);
                list.add(i);
                indexMap.put(num, list);
            }else {
                indexMap.put(num, new ArrayList<>(Arrays.asList(i)));
            }
        }*/

        // 使用 computeIfAbsent 简化操作
        for (int i = 0; i < n; i++) {
            Integer num = nums.get(i);
            indexMap.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
        }

        int ans = n / 2;
        for (List<Integer> a : indexMap.values()) {
            //数组可以视作是环形的,最大距离如下
            int maxLength = n - a.get(a.size() - 1) + a.get(0);
            //后依次去判断相同元素前后2个index的最值
            for (int i = 1; i < a.size(); i++) {
                maxLength = Math.max(maxLength, a.get(i) - a.get(i - 1));
            }
            //枚举不同的 x，计算相应的耗时，更新答案的最小值。
            ans = Math.min(ans, maxLength / 2);
        }
        return ans;

    }

    public int minimumSeconds2(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer num = nums.get(i);
            indexMap.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
        }

        int ans = n / 2;
        for (List<Integer> indexList : indexMap.values()) {
            indexList.add(indexList.get(0) + n);
            int mx = -1;
            for (int i = 1; i < indexList.size(); i++) {
                mx = Math.max(mx, (indexList.get(i) - indexList.get(i - 1)) / 2);
            }
            ans = Math.min(ans, mx);
        }
        return ans;

    }
}
