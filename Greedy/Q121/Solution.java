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


    //������
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // �п��ܲ��������ף���˽�����ĳ�ʼֵ����Ϊ 0
        int res = 0;

        // ö�����з���һ�ν��׵Ĺɼ۲�
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }


    //��̬�滮
    public int maxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;


    }
}