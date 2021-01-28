/**
 * @Description 47 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @date 2021/1/28 0028-9:19
 */
public class Sol47 {
    //dp 定义f(i,j)表示到达坐标为(i,j)的格子时能拿到的礼物总和的最大值，
    // 转移方程：f(i,j)=Max(f(i-1,j),f(i,j-1)) + grid[i][j]
    // TC:O(nm) SC:O(n)
    public int maxValue(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int rows=grid.length,cols=grid[0].length;
        int[] dp=new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left=0;
                int up=0;

                if(i>0) up=dp[j];
                if(j>0) left=dp[j-1];
                dp[j]=Math.max(up,left)+grid[i][j];
            }
        }
        return dp[cols-1];
    }
    // TC:O(nm) SC:O(1)  原地修改
    public int maxValue1(int[][] grid){
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int rows=grid.length,cols=grid[0].length;
        //初始化第一行
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j-1];
        }
        //初始化第一列
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];
    }
}
