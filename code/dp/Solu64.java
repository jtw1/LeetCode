package LeetcodeTest;
// [64] 最小路径和
// https://leetcode-cn.com/problems/minimum-path-sum/
import java.util.Arrays;

public class Solu64 {
    public int minPathSum(int[][] grid){
        int lenOfRow=grid.length,lenOfCol=grid[0].length;
        int[] dp=new int[lenOfCol];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        //dp数组每到新的一层就更新一次
        for (int i = 0; i < lenOfRow; i++) {
            dp[0] += grid[i][0];    //每行第一个位置只能由上一行的第一个位置到达
            for (int j = 1; j < lenOfCol; j++) {
                dp[j]=Math.min(dp[j], dp[j-1])+grid[i][j];
            }
        }
        return dp[lenOfCol-1];
    }
}