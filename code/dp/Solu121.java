/**
 * [121] 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Solu121 {
    public static void main(String[] args) {
        int[] prices=new int[]{7,1,5,3,6,4};
        int maxProfit=maxProfit1(prices);
        System.out.println("最大利润："+maxProfit);
    }
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 || prices.length==1)
            return 0;
         //法一
         int maxprofit = 0, buy = prices[0];
         for (int i = 1; i < prices.length; i++) {
             int temprofit =prices[i]-buy;
             maxprofit = Math.max(temprofit, maxprofit);
             if (temprofit<=0) {
                 buy = prices[i];
             }
         }
         return maxprofit;


    }

    public static int maxProfit1(int[] prices){
        //法二，根据牛顿莱布尼茨公式+动态规划思想
        //因为在数组中求两点的差，而两点之差可以转换成求和问题
        //区间和可以转换成求差的问题，求差问题，也可以转换成区间和的问题。
        //dp表示手上持有的现金数  dp[0]表示不持股时手上的现金数，dp[1]表示持股时手上的现金数
        // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
        int[] dp=new int[2];
        dp[0]=0;
        dp[1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0]=Math.max(dp[0],dp[1]+prices[i]);
            dp[1]=Math.max(dp[1],-prices[i]);
        }
        return dp[0];
    }

}