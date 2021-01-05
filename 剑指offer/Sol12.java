/**
 * @Description [面试题12] 矩阵中的路径  p89
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @date 2021/1/5 0005-10:08
 */
public class Sol12 {
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        if(board==null || board.length==0 || word==null || word.length()==0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if(hasPath(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean hasPath(char[][] board, char[] words,int row,int col,int index){
        int rows=board.length,cols=board[0].length;
        if(row>=rows || row<0 || col>=cols || col<0 || board[row][col] != words[index]) return false;
        if(index==words.length-1) return true;
        board[row][col]='\0';   //修改当前值，代表已经访问过,省去了visit数组的空间

        boolean isPath=hasPath(board,words,row-1,col,index+1) ||
                       hasPath(board,words,row+1,col,index+1) ||
                       hasPath(board,words,row,col+1,index+1) ||
                       hasPath(board,words,row,col-1,index+1);
        board[row][col]=words[index];  //还原board[row][col]的元素
        return isPath;
    }
}
