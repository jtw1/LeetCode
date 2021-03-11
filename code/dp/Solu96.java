/**
 * @Description 96 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @date 2021/3/11 0011-9:37
 */
public class Solu96 {
    /**
     * dp TC:O(n^2)  SC:O(n)
     * dp[i]表示长度为i的序列构成的不同的二叉搜索树个数
     * F(j,i)表示以j为根，长度为i的序列构成的不同的二叉搜索树个数
     * dp[i]=Sum(F(j,i))  (1<=j<=i)
     * F(j,i)=dp[j-1]*dp[i-j]  所以dp[i]=Sum(dp[j-1]*dp[i-j])  (1<=j<=i)
     */
    public int numTrees(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     * 数学法：TC:O(n)  SC:O(1)
     * 卡特兰数：f(0)=1,f(n+1)={2*(2n+1)/(n+2)}*f(n)
     */
    public int numTrees1(int n){
        long c=1;
        for (int i = 0; i < n; i++) {
            c=c*2*(2*i+1)/(i+2);
        }
        return (int)c;
    }
}
