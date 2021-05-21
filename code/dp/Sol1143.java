/**
 * @Description 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @date 2021/5/18 0018-9:38
 */
public class Sol1143 {
    //二维dp+压缩数组     TC:O(n^2)   SC:O(n)
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[] dp=new int[len2+1];
        for(int i=1;i<=len1;i++){
            int[] tmp=new int[len2+1];
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    tmp[j]=dp[j-1]+1;
                    //dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    tmp[j]=Math.max(dp[j],tmp[j-1]);
                    //dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            dp=tmp;
        }
        return dp[len2];
    }
}
