package Dp.Q198;

import java.util.Arrays;


//记忆化搜索
class Solution {
    private int[] nums, memo;

    public int rob(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(n - 1); // 从最后一个房子开始思考
    }

    // dfs(i) 表示从 nums[0] 到 nums[i] 最多能偷多少
    private int dfs(int i) {
        if (i < 0) { // 递归边界（没有房子）
            return 0;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
        memo[i] = res; // 记忆化：保存计算结果
        return res;
    }
}