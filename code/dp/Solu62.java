import java.util.Arrays;

// [62] 不同路径
// https://leetcode-cn.com/problems/unique-paths/description/
public class Solu62 {
    /**
     *
     * @param m 列数
     * @param n 行数
     * @return
     */
    public int uniquePaths(int m, int n) {
        //dp  TC:O(mn)  SC O(n)
        int[] dp = new int[m];
        Arrays.fill(dp,1);
        //外循环表示行，内循环表示列，第一层都是1，因为当只有一层时到达右下角都只有一种方法
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j]=dp[j-1]+dp[j]; //左边dp[j]表示当前位置，dp[j-1]表示当前位置左边，右边dp[j]表示当前位置上一格
            }
        }
        return dp[n-1];
    }
}