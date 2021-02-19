/**
 * @Description 695 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @date 2021/2/19-11:54
 */
public class Sol695 {
    public static final int[][] DIRECTIONS={{-1,0},{0,-1},{1,0},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int maxArea=0;
        for(int row=0;row<grid.length;row++) {
            for (int col = 0; col < grid[0].length; col++) {
                maxArea=Math.max(maxArea,dfs(grid,row,col));
            }
        }
        return maxArea;
    }


    public int dfs(int[][] grid,int row,int col){
        if(!inArea(grid,row,col) || grid[row][col]==0) return 0;

        grid[row][col]=0;
        int ans=1;
        for (int i = 0; i < 4; i++) {
            int newRow=row+DIRECTIONS[i][0];
            int newCol=col+DIRECTIONS[i][1];
            ans += dfs(grid,newRow,newCol);
        }
        return ans;
    }

    private boolean inArea(int[][] grid,int row,int col){
        return row>=0 && row<grid.length &&
                col>=0 && col<grid[0].length;
    }
}
