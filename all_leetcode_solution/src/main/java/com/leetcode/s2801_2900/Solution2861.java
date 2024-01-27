package com.leetcode.s2801_2900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 美丽塔Ⅰ
 */
public class Solution2861 {
    public static void main(String[] args) {
        Solution2861 solution = new Solution2861();
//        n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0], cost = [1,2,3]
        int[][] nums = {{1,1,1},{1,1,10}};
        List<List<Integer>> composition = Arrays.stream(nums)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        List<Integer> stock = new ArrayList<>(Arrays.asList(0, 0, 0));
        List<Integer> cost = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(solution.maxNumberOfAlloys(3,2,15,composition,stock,cost));
    }


    /**
     * 因为暴力会超时
     * 合成合金num越少花费越少，合成越多花费越多具有单调性
     * 故可以通过二分答案来完成该题
     * 遍历每一台机器，对最多可合成合金数量进行二分
     * 用每一个mid求一下合成mid数量的合金需要花费cst 元
     * 二分的边界即为预算budget >= cst
     */
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {


        int res = 0;
        for(int i = 0; i < k; i++){
            int l = 0;
            int r = Integer.MAX_VALUE;
            while(l < r){
                int mid = (l + r + 1) / 2;
                //接下来以合成mid数量的合金为条件求一下所需的费用cst
                long cst = 0;
                for(int j = 0; j < n && cst <= budget; j++){
                    if((long)mid * composition.get(i).get(j) - stock.get(j) > 0) {
                        cst += ((long)mid * composition.get(i).get(j) - stock.get(j)) * cost.get(j);
                    }
                }
                if(cst <= budget) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res = Math.max(res, l);
        }
        return res;


    }

}
