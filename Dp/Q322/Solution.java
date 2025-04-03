package Dp.Q322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int coin : coins){
            for(int j = coin; j < amount + 1; j++){
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] != 10001 ? dp[amount] : -1;
    }
}