/**
 * @Description
 * 和力扣54题相同  https://leetcode-cn.com/problems/spiral-matrix/submissions/
 * @date 2021/1/14 0014-21:40
 */
public class Sol29 {
    public int[] spiralOrder(int[][] matrix){
        //TC:O(mn)   SC:O(1)(除了输出数组)
        if(matrix==null || matrix.length==0) return new int[0];
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1,x=0;
        int[] res=new int[(right+1)*(bottom+1)];
        while(true){
            //左到右
            for (int i = left; i <= right; i++) {
                res[x++]=matrix[top][i];
            }
            if(++top>bottom) break;
            //上到下
            for (int i = top; i <= bottom; i++) {
                res[x++]=matrix[i][right];
            }
            if(left>--right) break;
            //右到左
            for (int i = right; i >= left; i--) {
                res[x++]=matrix[bottom][i];
            }
            if(top>--bottom) break;
            //下到上
            for (int i = bottom; i >= top; i--) {
                res[x++]=matrix[i][left];
            }
            if(++left>right) break;
        }
        return res;
    }
    public int[] spiralOrder1(int[][] matrix){
        //TC:O(mn)   SC:O(mn)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total=rows*columns;
        int[] order=new int[total];
        int row=0,column=0;
        int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex=0;
        for (int i = 0; i < total; i++) {
            order[i]=matrix[row][column];
            visited[row][column]=true;
            int nextRow=row+direction[directionIndex][0],nextColumn=column+direction[directionIndex][1];
            if(nextRow<0 || nextRow>=rows ||
               nextColumn<0 || nextColumn>=columns ||visited[nextRow][nextColumn]){
                directionIndex=(directionIndex+1)%4;
            }
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }
        return order;
    }
}
