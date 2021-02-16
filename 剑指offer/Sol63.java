/**
 * @Description 63 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @date 2021/2/16-8:57
 */
public class Sol63 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int NotHold=0,hold=-prices[0]; //分别代表不持股时和持股时手上的现金数

        for (int i = 1; i < prices.length; i++) {
            NotHold=Math.max(NotHold,hold+prices[i]);
            hold=Math.max(hold,-prices[i]);
        }
        return NotHold;
    }

    public int maxProfit1(int[] prices) {
        int len=prices.length;
        if(len<=1) return 0;
        int maxPro=0,buy=prices[0];
        for (int i = 1; i < len; i++){
            int tmpPro=prices[i]-buy;
            maxPro=Math.max(maxPro,tmpPro);
            if(tmpPro<=0){
                buy=prices[i];
            }
        }
        return maxPro;
    }
}
