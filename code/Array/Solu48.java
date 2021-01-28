/**
 * @Description [48] 图像旋转
 * https://leetcode-cn.com/problems/rotate-image/
 * @date 2020/12/19-14:51
 */
public class Solu48 {
    public void rotate(int[][] matrix){
        //TC:O(n^2)  SC:O(1)
        int len=matrix.length;
        //水平翻转  matrix[row][col]=matrix[len-1-row][col]
        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < len; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[len-1-i][j];
                matrix[len-1-i][j]=tmp;
            }
        }
        //对角线翻转   matrix[row][col]=matrix[col][row]
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
}
