package Dp.Q198;

import java.util.Arrays;


//���仯����
class Solution {
    private int[] nums, memo;

    public int rob(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1); // -1 ��ʾû�м����
        return dfs(n - 1); // �����һ�����ӿ�ʼ˼��
    }

    // dfs(i) ��ʾ�� nums[0] �� nums[i] �����͵����
    private int dfs(int i) {
        if (i < 0) { // �ݹ�߽磨û�з��ӣ�
            return 0;
        }
        if (memo[i] != -1) { // ֮ǰ�����
            return memo[i];
        }
        int res = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
        memo[i] = res; // ���仯�����������
        return res;
    }
}