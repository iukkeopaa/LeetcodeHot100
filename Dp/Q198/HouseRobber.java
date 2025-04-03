package Dp.Q198;

public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        int prev = 0;
        int curr = 0;

        // ÿ��ѭ�������㡰͵����ǰ����Ϊֹ������
        for (int i : nums) {
            // ѭ����ʼʱ��curr ��ʾ dp[k-1]��prev ��ʾ dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // ѭ������ʱ��curr ��ʾ dp[k]��prev ��ʾ dp[k-1]
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("�ܹ�͵�Ե�����߽����: " + rob(nums));
    }
}    