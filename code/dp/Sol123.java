/**
 * @Description 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
 * @date 2020/11/10 0010-16:50
 */
public class Sol123 {
    public int maxProfit(int[] prices){
        if(prices==null || prices.length<2) return 0;
        /**
         * dp0：初始化状态
         * dp1：第一次买入
         * dp2：第一次卖出
         * dp3：第二次买入
         * dp4：第二次卖出
         * 手上的现金
         */
        int dp0=0;
        int dp1=-prices[0];
        int dp2=0;
        int dp3=-prices[0];
        int dp4=0;
        for (int i = 1; i < prices.length; i++) {
            //这里省略dp0，因为dp0每次都是从上一个dp0来的相当于每次都是0
            //处理第一次买入、第一次卖出
            dp1=Math.max(dp1,dp0-prices[i]);
            dp2=Math.max(dp2,dp1+prices[i]);
            //处理第二次买入、第二次卖出
            dp3=Math.max(dp3,dp2-prices[i]);
            dp4=Math.max(dp4,dp3+prices[i]);
        }
        return dp4;
    }
}
