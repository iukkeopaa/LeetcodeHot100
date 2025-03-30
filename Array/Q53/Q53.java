package Array.Q53;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/27 ����2:33
 */
public class Q53 {

    public static int maxSubArray(int[] nums){

        int length = nums.length;

        int[] dp =new int[length];
        dp[0]=nums[0];
        int maxSum =dp[0];
        for (int i = 1; i < length; i++) {
            // ״̬ת�Ʒ���
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // ��������
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;

    }
}
