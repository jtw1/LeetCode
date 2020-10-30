package DFS;

import java.util.Scanner;

/**
 * @Description 463:岛屿的周长（10.30每日一题）
 * https://leetcode-cn.com/problems/island-perimeter/
 * @date 2020/10/30 0030-9:22
 */
public class Sol463 {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入矩阵的行和列：");
        int n=scan.nextInt(),m=scan.nextInt();
        int[][] grid=new int[n][m];
        System.out.println("输入矩阵元素：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j]=scan.nextInt();
            }
        }
        System.out.println("周长为："+islandPerimeter(grid));
    }
    public static int islandPerimeter(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    int cnt=0;
                    for (int k = 0; k < 4; k++) {
                        int tx=i+dx[k];
                        int ty=j+dy[k];
                        if(tx<0 || tx>=n || ty<0 || ty>=m || grid[tx][ty]==0){
                            cnt++;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }
}
