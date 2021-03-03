/**
 * @Description 221 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 如何理解三者取最小  https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 * @date 2021/3/2 0002-14:59
 */
public class Sol221 {
    public int maximalSquare(char[][] matrix){
        /**
         * dp  TC:O(mn)   SC:O(mn)
         * dp[i][j] 表示以 matrix[i][j] 为右下角，且只包含 1 的正方形的边长最大值。
         */
        int maxSide=0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return maxSide;

        int rows=matrix.length,columns=matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j]=='1'){
                    // 边界上有1，dp[i][j]只能为1
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }// 否则  dp[i][j]取它的左方，上方，和左上方对应位置最小值+1，这里取最小值的原因见题解中的图
                    else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    }
                    maxSide=Math.max(maxSide,dp[i][j]);
                }
            }
        }
        int maxSquare=maxSide*maxSide;
        return maxSquare;
    }
}
