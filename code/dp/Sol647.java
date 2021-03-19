/**
 * @Description 647 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @date 2021/3/19 0019-10:21
 */
public class Sol647 {
    // dp  TC:O(n^2)  SC:O(n^2)
    // dp[i][j]表示下标范围[i,j]的串是否是回文串
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int count=0;
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if((j-i)==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                }
                if(dp[i][j]) count++;
            }
        }
        return count+len;
    }
    // 法二  中心扩展  TC:O(n^2)  SC:O(1)
    public int countSubstrings1(String s){
        int len= s.length(),ans=0;
        for (int i = 0; i < (2 * len - 1); i++) {
            // i为奇数时，中心是一个数     i为偶数时，中心是两个数
            int left=i/2,right=i/2+i%2;

            while (left>=0 && right<len && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}
