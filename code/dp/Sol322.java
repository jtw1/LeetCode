import java.util.Arrays;

/**
 * @Description 322
 *
 * @date 2021/3/9 0009-11:27
 */
public class Sol322 {
    /**
     * dp  TC:O(n)  SC:O(sn)  n是金额，s是面额数
     * 定义dp[i]是租车金额i所需的最少硬币数量，计算dp[i]时，dp[0]到dp[i-1]都计算出来了
     *    转移方程：dp[i]=min(dp[i],dp[i-coins[j]]+1(coins[j]<=i))
     */
    public int coinChange(int[] coins, int amount){
        int max=amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        // dp数组初始值都是amount+1（代表不可能的情况）,在遍历时，金额凑不出则不更新，dp[amount]最后仍然是amount+1>amount，表示金额凑不出
        return dp[amount]>amount?-1:dp[amount];
    }
}
