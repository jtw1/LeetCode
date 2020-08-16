package LeetCodeTest;
/**
 * [518] 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/description/
 */
public class Solu518 {
    public int change(int amount, int[] coins) {
        //dp 与·爬楼梯问题不同的是，这里计算的是组合数（1->2和2->1当作一种情况），而爬楼梯问题计算的是排列数（1->2和2->1当作2种情况）
        int[] dp = new int[amount+1];
        dp[0]=1;  // 有一种方案凑成0元，那就是一个也不选
        //内外循环如果调换位置会出现重复的情况
        for(int coin:coins){
            // 记录每添加一种面额的零钱，总金额j的变化
            for(int i=1;i<=amount;i++){
                if(i>=coin) dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}