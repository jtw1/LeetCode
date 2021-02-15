/**
 * @Description 60 n个骰子的点数
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * 题解 ：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/dong-tai-gui-hua-yi-li-jie-ban-ben-by-zh-gyx3/
 *
 * @date 2021/2/15-8:22
 */
public class Sol60 {
    public double[] dicesProbability(int n) {
        //dp[i][j],代表i个骰子，朝上一面的点数之和为j的所有可能值出现的次数
        // ex:dp[2][5]=dp[1][1]+dp[1][2]+dp[1][3]+dp[1][4]
        // dp[1][1]代表第一次点数1，第二次点数4
        // dp[i][j] = Sum(dp[i-1][j-k]  (j-k>=1))
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = i; j <= 6 * i; j++)
                for(int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i-1][j - k];

        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }
}
