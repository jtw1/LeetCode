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
    //贪心   因为交易次数不受限，如果可以把所有的上坡全部收集到，一定是利益最大化的
    // 贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
    public int maxProfit1(int[] prices){
        if(prices==null || prices.length<2) return 0;
        int ans=0;
        for (int i = 1; i < prices.length; i++) {
            // 卖出有利可图时
            if(prices[i]>prices[i-1]){
                ans += prices[i]-prices[i-1];
            }
        }
        return ans;
    }
}
