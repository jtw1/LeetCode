import java.util.LinkedList;
import java.util.Queue;
/**
 * @Description 200 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @date 2021/2/18-16:33
 */
public class Sol200 {
    private static final int[][] DIRECTIONS={{-1,0},{0,-1},{1,0},{0,1}};

    public int numIslands(char[][] grid){
        if(grid==null || grid.length==0) return 0;
        int rows=grid.length;
        int cols=grid[0].length;
        int isLandsNum=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++isLandsNum;
                    dfs(grid, i, j);
                    /**
                     * bfs
                     * bfs(grid,i,j);
                     * isLandsNum++;
                     */
                }
            }
        }
        return isLandsNum;
    }

    private void dfs(char[][] grid,int row,int col){
        int rows=grid.length;
        int cols=grid[0].length;
        if(!inArea(grid,row,col) || grid[row][col]=='0') return;
        grid[row][col]='0'; //搜索过的位置标记为0
        for (int i = 0; i < 4; i++) {
            int newRow=row+DIRECTIONS[i][0];
            int newCol=col+DIRECTIONS[i][1];
            dfs(grid,newRow,newCol);
        }
    }

    private void bfs(char[][] grid,int row,int col){
        Queue<int[]> list=new LinkedList<>();
        list.add(new int[]{row,col});
        while (!list.isEmpty()){
            int[] cur=list.remove();
            int tmpRow=cur[0],tmpCol=cur[1];
            if(inArea(grid,tmpRow,tmpCol) && grid[tmpRow][tmpCol]=='1'){
                grid[tmpRow][tmpCol]='0';
                for (int i = 0; i < 4; i++) {
                    int newRow=tmpRow+DIRECTIONS[i][0];
                    int newCol=tmpCol+DIRECTIONS[i][1];
                    list.add(new int[]{newRow,newCol});
                }
            }
        }
    }

    private boolean inArea(char[][] grid,int row,int col){
        return row>=0 && row<grid.length &&
               col>=0 && col<grid[0].length;
    }
}
