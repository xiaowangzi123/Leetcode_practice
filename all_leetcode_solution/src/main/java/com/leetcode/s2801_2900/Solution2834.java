package com.leetcode.s2801_2900;

import java.util.*;

/**
 * 找出美丽数组的最小和
 */
public class Solution2834 {
    public static void main(String[] args) {
        Solution2834 solution = new Solution2834();
        //4
        System.out.println(solution.minimumPossibleSum(2, 3));
        //8
        System.out.println(solution.minimumPossibleSum(3, 3));
        //1
        System.out.println(solution.minimumPossibleSum(1, 1));
        //750000042
        System.out.println(solution.minimumPossibleSum3(1000000000, 1000000000));
    }

    public static final int MOD = 1000000007;

    /**
     * n=1000000000超时
     */
    public int minimumPossibleSum(int n, int target) {
        long l = System.currentTimeMillis();
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        int num = 2;

        while (nums.size() < n) {
            if (!nums.contains(target - num)) {
                nums.add(num);
            }
            num++;
        }

        long sum = 0;
        for (int value : nums) {
            sum += value;
        }
        System.out.println("耗时" + (System.currentTimeMillis() - l));
        return (int) (sum % MOD);
    }

    /**
     * 我们发现了规律，对于 [1, target−1] 内的数字：
     * <p>
     * 1 和 target-1 只能选其中一个，为了使美丽数组的总和最小，我们选1。
     * 2 和 target-2 只能选其中一个，为了使美丽数组的总和最小，我们选2。
     * …
     * 一直到 ⌊target/2⌋，无论 target 是奇数还是偶数，它都可以选。
     * 设 m = min(n, ⌊target/2⌋)，我们选择1~m，总和为 m(m+1)/2。
     * 此时还剩下 n-m 个数，只能从 target 开始往后选，一直到 target+n-m-1。
     */
    public int minimumPossibleSum2(int n, int target) {
        int m = Math.min(target / 2, n);
        return (int) ((cal(1, m) + cal(target, target + n - m - 1)) % MOD);
    }

    // 辅助函数 - 返回 [left, right] 区间内元素和
    private long cal(int left, int right) {
        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 对上述的优化，分两种情况
     * 为了让数组之和最小，我们按照 1,2,3,⋯的顺序考虑，
     * 但添加了x之后，就不能添加 target−x，因此最大可以添加到 ⌊target/2⌋，
     * 如果个数还不够 n个，就继续从 target,target+1,target+2,⋯ 依次添加。
     * 由于添加的数字是连续的，所以可以用等差数列求和公式快速求解。
     */
    public int minimumPossibleSum3(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        } else {
            long part1 = ((long) (1 + m) * m / 2);
            long part2 = ((long) target + target + (n - m) - 1) * (n - m) / 2;
            //下面转换范围超限制
//            long l2 = (long) (target + target + (n - m) - 1) * (n - m) / 2;
            return (int) ((part1 + part2) % MOD);
        }
    }

}