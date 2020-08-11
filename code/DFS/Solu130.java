package LeetcodeTest;
// [130] 被围绕的区域
// https://leetcode-cn.com/problems/surrounded-regions/
public class Solu130 {
    public void solve(char[][] board) {
        //DFS TC:O(m*n)   SC:O(m*n)
        //算法：所有边缘o以及和边缘o相邻的o不变，剩下的o变为X
        //把所有边界以及和边界o相邻的的o标记为#，剩下的不变O
        //然后遍历数组，为O，则改为X  为#，则改为O   
        if(board==null || board.length==0) return;
        int m=board.length,n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 从边缘o开始搜索
                boolean isEdge = (i==0 || j==0 || i==m-1 || j==n-1);
                if(isEdge && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //然后遍历数组，为O，则改为X  为#，则改为O   
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    
    //把所有边界以及和边界o相邻的的o标记为#，剩下的不变
    public void dfs(char[][] board,int i,int j){
        //board[i][j]=='#'代表已经处理过，只处理是'o'的合法字符
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='#'){
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j); //上
        dfs(board,i+1,j); //下
        dfs(board,i,j-1); //左
        dfs(board,i,j+1); //右
    }
}