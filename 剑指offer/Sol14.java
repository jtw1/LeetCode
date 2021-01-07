/**
 * @Description [14] 剪绳子 p96
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @date 2021/1/7 0007-14:38
 */
public class Sol14 {
    public int cuttingRope(int n) {
        if(n<2) return 0;

        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i < (n + 1); i++) {
            for (int j = 2; j < i; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[n];
    }

    //数学方法
    //https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-fa/
    public int cuttingRope1(int n){
        if(n==2 || n==3) return n-1;
        int res=1;
        while (n>4){
            n -= 3;
            res *= 3;
        }
        return n*res;
    }
    //14-II
    public int cuttingRope2(int n){
        if(n<2) return 0;
        if(n<=3) return n-1;

        long res=1;
        while(n > 4){
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res*n%1000000007);
    }
}
