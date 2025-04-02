package Dp.Q70;

public class ClimbingStairsDP {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // 创建一个数组来存储每一步的结果
        int[] dp = new int[n + 1];
        // 初始化第 1 阶和第 2 阶的方法数
        dp[1] = 1;
        dp[2] = 2;
        // 从第 3 阶开始递推
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("到达第 " + n + " 阶楼梯的方法数: " + climbStairs(n));
    }
}    