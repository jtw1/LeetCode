/**
 * @Description 72 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
 * @date 2021/3/9 0009-10:02
 */
public class Solu72 {
    /**
     * dp  TC: O(mn)  SC:O(mn)
     * 思路：本质不同的操作有三种  1 单词A中插入一个字符   2 单词中插入一个字符B  3  1 修改单词A中一个字符
     * 定义D[i][j]表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。
     * 当我们获得 D[i][j-1]，D[i-1][j] 和 D[i-1][j-1] 的值之后就可以计算出 D[i][j]。
     * D[i][j-1]为A 的前 i 个字母和 B 的前 j-1 个字母之间的编辑距离
     *      对于B的第j个字符，在A的末尾添加一个相同字符，D[i][j]最小为 D[i][j-1]+1
     * D[i-1][j]为A 的前 i-1 个字母和 B 的前 j 个字母之间的编辑距离
     *      对于的第i个字符，在B的末尾添加一个相同字符，D[i][j]最小为 D[i-1][j]+1
     * D[i-1][j-1]为A 的前 i-1 个字母和 B 的前 j-1 个字母之间的编辑距离
     *      对于A的第i个字符，修改B的第j个字符使他们相同，D[i][j]最小为 D[i-1][j-1]+1
     *      如果A的第i个字符和B的第j个字符原本就相同，那么实质上不需要修改，D[i][j]最小为 D[i-1][j-1]
     */
    public int minDistance(String word1, String word2){
        int m=word1.length();
        int n=word2.length();
        //有一个串是空串
        if(m*n==0) return m+n;

        int[][] dp=new int[m+1][n+1];
        //边界状态初始化：一个空串和一个非空串的编辑距离  dp[i][0]=i,dp[0][j]=j
        for (int i = 0; i < m+1; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j]=j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left=dp[i-1][j]+1;
                int down=dp[i][j-1]+1;
                int leftDown=dp[i-1][j-1];
                // s.charAt(i-1)实际上才是s的第i个字母，
                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    leftDown++;
                }
                dp[i][j]=Math.min(left,Math.min(down,leftDown));
            }
        }
        return dp[m][n];
    }

    //  滚动数组优化  每次只需要三个之前的状态，对于二维数组可以如下
    // TC: O(mn)  SC:O(n)
//    int[][] dp = new int[2][n + 1];
//    for (int i = 0; i < m+1; i++) {
//        dp[i][0]=i;
//    }
//    for (int i = 1; i < m + 1; i++) {
//        dp[i&1][0]=i;
//        for (int j = 1; j < n + 1; j++){
//            int left=dp[(i-1)&1][j]+1;
//            int down=dp[i&1][j-1]+1;
//            int leftDown=dp[(i-1)&1][j-1];
//            // s.charAt(i-1)实际上才是s的第i个字母，
//            if (word1.charAt(i-1) != word2.charAt(j-1)){
//                leftDown++;
//            }
//            dp[i&1][j]=Math.min(left,Math.min(down,leftDown));
//        }
//    }
//    return dp[m&1][n];
}
