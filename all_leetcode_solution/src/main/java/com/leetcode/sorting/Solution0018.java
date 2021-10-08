package com.leetcode.sorting;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/10/08
 * @description : 四数之和
 */
public class Solution0018 {
    public static void main(String[] args) {
        Solution0018 obj = new Solution0018();
        int[] arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = obj.fourSum(arr, 0);

        lists.forEach(item -> System.out.println(item));
        System.out.println("----------------------------");

        //List遍历方式
        /*System.out.println("-------增强for--------------");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        System.out.println("-------for--------------");
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }

        System.out.println("-------Iterator--------------");
        Iterator<List<Integer>> it = lists.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-------ListIterator--------------");
        ListIterator<List<Integer>> listIt = lists.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        System.out.println("-------Lambda--------------");
        lists.forEach(item -> System.out.println(item));*/
    }

    /**
     * 算法流程：
     * 1.对于数组长度n，如果数组为 null或者数组长度小于3，返回[]。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return lists;
        }

        int n = nums.length;
        //排序
        Arrays.sort(nums);
        //双指针
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //四数之和大于target，没有找到，结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //当前值加上最后三个元素之和小于target，说明当前值加上其他数也不会大于target，跳出当前循环，继续下一循环
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //四数之和大于target，没有找到，结束循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //四数之和小于target，跳出当前循环，继续下一循环
                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return lists;
    }

}