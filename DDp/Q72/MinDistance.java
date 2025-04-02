package DDp.Q72;

public class MinDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 创建二维数组 dp 用于存储子问题的解
        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("将 " + word1 + " 转换为 " + word2 + " 的最少操作数是: " + minDistance(word1, word2));
    }
}    