/**
 * @Description 买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/zhuang-tai-ya-suo-shi-guan-yu-kshi-fou-dao-xu-yao-/
 * @date 2020/11/11 0011-9:20
 */
public class Sol188 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int len=prices.length;
        if(k>len/2){
            int dp0=0,dp1=-prices[0];
            for (int i = 1; i < len; i++) {
                dp0=Math.max(dp0,dp1+prices[i]);
                dp1=Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        int[][] dp=new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0]=0;
            dp[i][1]=-prices[0];
        }

        for (int i = 0; i < len; i++) {
            for (int j = k; j >0 ; j--) {
                //处理第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);
            }
        }
        return dp[k][0];
    }
}
