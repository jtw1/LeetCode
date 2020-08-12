package LeetcodeTest;
// [279] 完全平方数
// https://leetcode-cn.com/problems/perfect-squares/
public class Solu279 {
    public int numSquares(int n) {
        //dp TC:O(n*sqrt(n))    SC:O(n)
        // int[] dp = new int[n+1];   //初始化默认值都为0
        // for(int i=1;i<=n;i++){
        //     dp[i]=i; //最坏情况下i可以分解为i个相加
        //     for(int j=1;i-j*j>=0;j++){
        //         dp[i]=Math.min(dp[i],dp[i-j*j]+1);  //动态转移方程，i表示当前数，j*j表示完全平方数
        //     }
        // }
        // return dp[n];

        //法二  TC:O(根号n)   SC:O(1) 
        // 数学方法  四平方和定理  任何一个自然数都可以表示为4个整数的平方和   
        // 三平方和定理n不等于4^k∗(8∗m+7)等价于n=a^2+b^2+c^2   （k,m,a,b,c都是整数）

        if(isSquare(n)) return 1;
        while(n%4==0){
            n >>= 2;
        }
        if(n%8==7) return 4;
        for (int i = 1; i*i < n; i++) {
            if(isSquare(n-i*i)) return 2;  //判断是否可以分解为两个数的平方和
        }
        return 3;
    }
    //判断一个数是否是平方数
    private boolean isSquare(int n){
        int sq = (int)Math.sqrt(n);
        return n==sq*sq;
    }
    
}