package DDp.Q62;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行，因为只能从左向右走，所以路径数都为 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 初始化第一列，因为只能从上向下走，所以路径数都为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 填充 dp 数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("不同路径的数量: " + uniquePaths(m, n));
    }
}    