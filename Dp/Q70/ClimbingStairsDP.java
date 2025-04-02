package Dp.Q70;

public class ClimbingStairsDP {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // ����һ���������洢ÿһ���Ľ��
        int[] dp = new int[n + 1];
        // ��ʼ���� 1 �׺͵� 2 �׵ķ�����
        dp[1] = 1;
        dp[2] = 2;
        // �ӵ� 3 �׿�ʼ����
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("����� " + n + " ��¥�ݵķ�����: " + climbStairs(n));
    }
}    