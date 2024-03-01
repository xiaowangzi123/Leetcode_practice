package com.leetcode.s2601_2700;

/**
 * 使二叉树所有路径值相等的最小代价
 * TODO
 */
public class Solution2673 {
    public static void main(String[] args) {
        Solution2673 solution = new Solution2673();
        int[] nums = new int[]{1, 5, 2, 2, 3, 3, 1};
        int[] nums2 = new int[]{5, 3, 3};
        int[] nums3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(solution.minIncrements(7, nums));
        System.out.println(solution.minIncrements(3, nums2));
        System.out.println(solution.minIncrements(15, nums3));
    }

    /**
     * 对于兄弟叶子节点，可以考虑将较小的值，增加到和较大值一样，增加|x-y|
     * 对于兄弟非叶子节点A、B，跟路径到此路径之前的数据都相同，所以把路径和从叶子一起计算
     * 把B节点值与A的叶子节点最大值相加得到a,把A节点值与B的叶子节点最大值相加得到b,两者相减
     * 计算最后一个非叶子节点值
     */
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        // 从最后一个非叶节点开始算
        for (int i = n / 2; i > 0; i--) {
            // 两个子节点变成一样的
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            // 累加路径和
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return ans;

    }


    /**
     * 对于兄弟叶子节点，可以考虑将较小的值，增加到和较大值一样，增加|x-y|
     * 待考虑完所有叶节点之后，互为兄弟节点的叶节点的值两两相等（并且根到它们的路径值显然也相等）。
     *
     * 所有的叶节点都无需进行操作。我们就可以将它们全部移除。
     * 为了使得路径值保持不变，我们可以将叶节点的值增加至它们的双亲节点。
     * 这样一来，所有的双亲节点都变成了新的叶节点，我们重复进行上述操作即可。
     * 当只剩一个节点（根节点）时，就可以得到最终的答案。
     *
     */
    public int minIncrements2(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            // 叶节点 i 和 i+1 的双亲节点下标为 i/2（整数除法）
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return ans;
    }
}
