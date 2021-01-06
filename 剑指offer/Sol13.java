import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description [13] 机器人运动范围
 * @date 2021/1/6 0006-9:05
 */
public class Sol13 {
    public int movingCount(int m, int n, int k) {
        if(k<0 || m<=0 || n<=0) return 0;
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j]=false;
            }
        }
        int count=movingCountCore(m,n,k,0,0,visited);
        return count;
    }

    public int movingCountCore(int m, int n, int k,int row,int col,boolean[][] visited){
        int count=0;
        if(check(m,n,k,row,col,visited)){
            visited[row][col]=true;;
            count=1+movingCountCore(m,n,k,row-1,col,visited)
                   +movingCountCore(m,n,k,row+1,col,visited)
                   +movingCountCore(m,n,k,row,col-1,visited)
                   +movingCountCore(m,n,k,row,col+1,visited);
        }
        return count;
    }

    public boolean check(int m, int n, int k,int row,int col,boolean[][] visited){
        if(row>=0 && row<m && col>=0 && col<n &&
           getDigitSum(row)+getDigitSum(col)<=k && !visited[row][col])   return true;
        return false;
    }

    public int getDigitSum(int num){
        int sum=0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    //BFS
    public int movingCount1(int m, int n, int k){
        if(k<0 || m<=0 || n<=0) return 0;
        Queue<int[]> queue=new LinkedList<>();
        //从[0,0]开始，我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索
        int[] dx={0,1};
        int[] dy={1,0};
        boolean[][] vis=new boolean[m][n];
        queue.offer(new int[]{0,0});
        vis[0][0]=true;
        int ans=1;
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int x=cell[0],y=cell[1];
            for (int i = 0; i < 2; i++) {
                int tx=dx[i]+x;
                int ty=dy[i]+y;
                if(!check(m,n,k,tx,ty,vis)) continue;
                queue.offer(new int[]{tx,ty});
                vis[tx][ty]=true;
                ans++;
            }
        }
        return ans;
    }
}
