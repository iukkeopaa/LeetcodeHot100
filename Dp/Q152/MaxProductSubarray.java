package Dp.Q152;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxEndingHere;
            maxEndingHere = Math.max(Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]), nums[i]);
            minEndingHere = Math.min(Math.min(temp * nums[i], minEndingHere * nums[i]), nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}    