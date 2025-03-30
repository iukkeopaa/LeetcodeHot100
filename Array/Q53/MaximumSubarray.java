package Array.Q53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // ����״̬����
        int[] dp = new int[n];
        // ��ʼ�� dp[0]
        dp[0] = nums[0];
        // ��¼����
        int maxSum = dp[0];

        // ��������
        for (int i = 1; i < n; i++) {
            // ״̬ת�Ʒ���
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // ��������
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }


    //

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
    public static int maxSubArray4(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x; // ��ǰ��ǰ׺��
            ans = Math.max(ans, preSum - minPreSum); // ��ȥǰ׺�͵���Сֵ
            minPreSum = Math.min(minPreSum, preSum); // ά��ǰ׺�͵���Сֵ
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("���͵�����������ĺ�Ϊ: " + solution.maxSubArray(nums));
    }
}    