package Greedy.Q55;

import java.util.Scanner;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        //pos表示需要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }

        }
        return pos == 0;

    }


    public boolean canJump1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = true;

                }

            }
            if (dp[len - 1]) {
                return true;
            }

        }
        return dp[len - 1];

    }


    public boolean canJump4(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = true;

                }
            }

        }
        return dp[len - 1];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组元素，以空格分隔:");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        boolean result = canJump(nums);
        System.out.println(result);
        scanner.close();
    }
}    