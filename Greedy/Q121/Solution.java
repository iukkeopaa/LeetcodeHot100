package Greedy.Q121;

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int p : prices) {
            ans = Math.max(ans, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return ans;
    }


    //暴力解
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 有可能不发生交易，因此结果集的初始值设置为 0
        int res = 0;

        // 枚举所有发生一次交易的股价差
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }


    //动态规划
    public int maxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;


    }
}