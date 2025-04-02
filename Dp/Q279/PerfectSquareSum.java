package Dp.Q279;

public class PerfectSquareSum {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("和为 " + n + " 的完全平方数的最少数量是: " + numSquares(n));
    }
}    