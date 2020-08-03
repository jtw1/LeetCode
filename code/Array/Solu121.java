package LeetCodeTest;
/**
 * [121] 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Solu121 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 || prices.length==1)
            return 0;
        //法一
        // int maxprofit = 0, buy = prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     int temprofit =prices[i]-buy;
        //     maxprofit = Math.max(temprofit, maxprofit);
        //     if (temprofit<=0) {
        //         buy = prices[i];
        //     }
        // }
        // return maxprofit;

        //法二，根据牛顿莱布尼茨公式+动态规划思想
        //因为在数组中求两点的差，而两点之差可以转换成求和问题
        //区间和可以转换成求差的问题，求差问题，也可以转换成区间和的问题。
        //最大连续子数组和可以使用动态规划求解， dp[i]表示以i为结尾的最大连续子数组和，
        //递推公式为：dp[i]=max(0,dp[i−1]+prices[i+1] - prices[i])  
        //dp[i]变为0时，等价于方法一中的买入日期变更为当前一天
        
        int maxprofit = 0, last = prices[0];
        for (int i = 0; i < prices.length-1; i++) {
            last = Math.max(0, last+prices[i+1]-prices[i]);
            maxprofit = Math.max(last, maxprofit);
        }
        return maxprofit;
    }
}