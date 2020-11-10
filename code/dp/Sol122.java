/**
 * @Description 买卖股票的最佳时机二
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @date 2020/11/9 0009-21:38
 */
public class Sol122 {
    public int maxProfit(int[] prices) {
        //dp  TC:O(n)   SC:O(1)
        if(prices==null || prices.length<2) return 0;
        int cash=0;   //持有现金
        int hold=-prices[0];   //持有股票时，手上的现金

        int preCash=cash;
        int preHold=hold;
        for (int i = 0; i < prices.length; i++) {
            cash=Math.max(preCash,preHold+prices[i]);
            hold=Math.max(preHold,preCash-prices[i]);

            preCash=cash;
            preHold=hold;
        }
        return cash;
    }
}
