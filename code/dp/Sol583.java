/**
 * @Description 583 两个字符串的删除操作
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * @date 2021/5/25 0025-9:32
 */
public class Sol583 {
    // 转化为求两个字符串的最长公共子序列  需要修改的次数即  两个字符串的长度和-最长公共子序列长度*2
    // 滚动数组优化空间   TC:O(mn)  SC:O(n)
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int[] dp=new int[len2+1];
        for(int i=1;i<=len1;i++){
            int[] tmp=new int[len2+1];
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    tmp[j]=dp[j-1]+1;
                }else{
                    tmp[j]=Math.max(dp[j],tmp[j-1]);
                }
            }
            dp=tmp;
        }
        return len1+len2-2*dp[len2];
    }
}
