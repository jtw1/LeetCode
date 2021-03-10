/**
 * @Description 19 正则表达式匹配 (与主站第10题相同)
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @date 2021/3/10 0010-11:23
 */
public class Sol19 {
    public boolean isMatch(String s, String p){
        if (s==null || p==null) return false;
        int sLen=s.length();
        int pLen=p.length();

        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0]=true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if (isMatch(s,p,i,j-1)){
                        dp[i][j]=dp[i][j] || dp[i-1][j];
                    }
                }else{
                    if (isMatch(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public boolean isMatch(String s, String p,int i,int j){
        if (i==0) return false;
        if (p.charAt(j-1)=='.') return true;
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
