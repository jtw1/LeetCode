package GreedySelector;

/**
 * @Description [861] 翻转矩阵后的得分 day
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * @date 2020/12/7 0007-9:35
 */
public class Sol861 {
    //法一 贪心
    //TC:O(mn)  SC:O(1)
    public int matrixScore(int[][] A){
        int m=A.length,n=A[0].length;
        int ret=m*(1<<(n-1));  //每一行最高位肯定都要置一，每一行的最高位对整个分数的贡献为2^(n-1)

        for(int i=1;i<n;i++){
            int nOnes=0; //记录每一列1的个数
            for (int j = 0; j < m; j++) {
                if(A[j][0]==1){
                    //如果该行第一个元素是1，则该行不用行翻转，A[j][i]位置的实际值就是A[j][i]
                    nOnes += A[j][i];
                }else{
                    //如果该行第一个元素是0，则该行需要行翻转，A[j][i]位置的实际值就是1-A[j][i]
                    nOnes += (1-A[j][i]);
                }
            }
            //为使每一列1的个数尽可能多，k取每一列0的数目，1的数目的较大值，即是列反转后1的数量
            int k=Math.max(nOnes,m-nOnes);
            ret += k*(1<<(n-1-i));
        }
        return ret;
    }
}
