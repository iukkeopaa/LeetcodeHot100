package Greedy.Q45;

public class MinimumJumps {
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("最小跳跃次数: " + jump(nums));
    }
}    