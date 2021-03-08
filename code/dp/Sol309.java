/**
 * @Description 309 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @date 2021/3/8 0008-10:37
 */
public class Sol309 {
    /**
     * dp  TC:O(n) SC:O(1)
     * 这里的「处于冷冻期」指的是在第 i 天结束之后的状态。也就是说：如果第 i 天结束之后处于冷冻期，那么第 i+1 天无法买入股票。
     * f[i]表示 第i天结束后 的累计最大收益（注意是第i天结束后）。总共有三种状态：
     * 持有一支股票  对应的累计最大收益为f[i][0],
     *    这支股票可以是第i-1天就持有，f[i-1][0]，或者是第i天买入，那么第i-1天就不能持有股票且不处于冷冻期
     *    f[i][0]=max(f[i-1][0],f[i-1][2]-price[i])
     * 不持有股票，且属于冷冻期 ，对应的累计最大收益为f[i][1],
     *    我们在第 i 天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明在第 i−1 天时我们必须持有一支股票，
     *    f[i][1]=f[i-1][0]+price[i]
     * 不持有股票，且不属于冷冻期 ，对应的累计最大收益为f[i][2],
     *    说明当天没有进行任何操作，即第i-1天不持有股票：如果处于冷冻期，对应状态为f[i-1][1]
     *    如果不处于冷冻期，对应状态为f[i-1][2]
     *
     */
    public int maxProfit(int[] prices){
        if (prices==null || prices.length==0) return 0;

        int len=prices.length;
        int f0=-prices[0];
        int f1=0;
        int f2=0;
        for (int i = 1; i < len; i++) {
            int newf0=Math.max(f0,f2-prices[i]);
            int newf1=f0+prices[i];
            int newf2=Math.max(f1,f2);
            f0=newf0;
            f1=newf1;
            f2=newf2;
        }
        return Math.max(f1,f2);
    }
}
