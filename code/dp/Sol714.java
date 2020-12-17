/**
 * @Description [714] 买卖股票最佳时机含手续费 day
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @date 2020/12/17 0017-10:32
 */
public class Sol714 {
    public int maxProfit(int[] prices, int fee){
        // 定义状态dp[i][0](sell) 表示第 i 天交易完后手里没有股票的最大利润，
        // dp[i][1](buy) 表示第 i 天交易完后手里持有一支股票的最大利润（i从0开始）
        //TC:O(n)  SC:O(1)
        int sell=0,buy=-prices[0];
        for (int i = 0; i < prices.length; i++) {
            sell=Math.max(sell,buy+prices[i]-fee);
            buy=Math.max(buy,sell-prices[i]);
        }
        return sell;
    }
}
