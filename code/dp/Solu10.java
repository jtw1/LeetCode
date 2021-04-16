/**
 * @Description 10 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @date 2021/3/10 0010-10:13
 */
public class Solu10 {
    /**
     * dp TC:O(mn)  SC:O(mn)
     * ‘.’可以当成任何字符，
     * '*'可以匹配0个或多个前面的元素，即对于 “a*”，可以看成 “aa”,也可以直接忽略这两个字符
     * '*'表示它前面的字符(所在字符串的前面的字符)可以出现任意次（含0次）
     */
    public boolean isMatch(String s, String p){
        if (s==null || p==null) return false;
        int sLen=s.length();
        int pLen=p.length();
        // dp[i][j]表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        /**
         * p和s都是空串时，是可以匹配的  dp[0][0]=true;
         * 非空串s和空正则串p必不匹配 dp[1][0]=dp[2][0]=...=dp[sLen][0]=false
         */
        dp[0][0]=true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                /**
                 * p的第j个字符（p.charAt(j-1)）是*时，分两种情况
                 *      1：s 的第 i 个字符与 p 中的第 j-1 个字符匹配   dp[i][j]=dp[i][j] || dp[i-1][j];
                 *      2：s 的第 i 个字符与 p 中的第 j-1 个字符不匹配  则舍弃*以及*前面的那个字符，dp[i][j]=dp[i][j-2];
                 * p的第j个字符不是*时，判断s 的第 i 个字符与 p 中的第 j 个字符是否匹配，如果匹配  则dp[i][j]=dp[i-1][j-1]
                 */
                if (p.charAt(j-1)=='*'){
                    // 题目要求中提到 保证每次出现字符 * 时，前面都匹配到有效的字符，所以*不会出现在p的首位置，所以不会出现j-2<0的情况
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

    /**
     * 判断s的第i个字符和p的第j个字符是否匹配，下标是从0开始的，p的第j个字符即p.charAt(j-1)
     */
    public boolean isMatch(String s, String p,int i,int j){
        //上面再使用isMatch函数时，i等于0时，s指向的是空串，p不是，在这种情况下，只有p是空串或者p中*至少是交替出现时，dp[i][j]才可能为true
        if (i==0) return false;
        if (p.charAt(j-1)=='.') return true;
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
