package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 高度检查器
 */
public class Solution1051 {
    public static void main(String[] args) {
        Solution1051 obj = new Solution1051();
        int[] arr = {1, 1, 4, 2, 1, 3};
        System.out.println(obj.heightChecker(arr));
    }

    //题目简单来说就是找排序后，位置值不一样的数量
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] temp = heights.clone();
        Arrays.sort(temp);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                count++;
            }
        }
        return count;
    }

    //桶排序
    public int heightChecker2(int[] heights) {
        // 值的范围是1 <= heights[i] <= 100，因此需要1,2,3,...,99,100，共101个桶
        int[] arr = new int[101];
        // 遍历数组heights，计算每个桶中有多少个元素，也就是数组heights中有多少个1，多少个2，。。。，多少个100
        // 将这101个桶中的元素，一个一个桶地取出来，元素就是有序的
        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            // arr[i]，i就是桶中存放的元素的值，arr[i]是元素的个数
            // arr[i]-- 就是每次取出一个，一直取到没有元素，成为空桶
            while (arr[i]-- > 0) {
                // 从桶中取出元素时，元素的排列顺序就是非递减的，然后与heights中的元素比较，如果不同，计算器就加1
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}