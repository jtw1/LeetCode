package LeetcodeTest;

//import java.util.Arrays;

// 343 整数拆分
// https://leetcode-cn.com/problems/integer-break/
public class Solu343 {
    public int integerBreak(int n) {
        //dp[i] 整数i拆分得到的最大乘积  dp[1]=dp[0]=0        TC:O(n^2) SC:O(n)
        //把i分成j和 i-j 
        // (1) i-j可以继续拆分 则dp[i]=j*dp[i-j]
        // (2) i-j不可以继续拆分 则dp[i]=j*（i-j） 综上dp[i]
        //int[] dp = new int[n+1];
        //for(int i=2;i<=n;i++){
        //    int curMax=0;
        //    for(int j=1;j<i;j++){
        //        curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j])); //和前一个比较，前一个大于现在的，把现在的拆分成1*（i-1）
        //    }
        //    dp[i]=curMax;
        //} 
        //return dp[n];

        //法二：TC:O(n) SC:O(n)
        if(n<4) return n-1;
        int[] dp = new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(Math.max(2*(i-2),2*dp[i-2]),Math.max(3*(i-3),3*dp[i-3]));
        } 
        return dp[n];
        
    }
}