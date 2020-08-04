package LeetCodeTest;
// [5] 最长回文子串
// https://leetcode-cn.com/problems/longest-palindromic-substring/description/
public class Solu5 {
    //暴力 TC:O(n^3)  SC:O(1)
    // public String longestPalindrome(String s) {
    //     if(s==null || s.length()==0) return null;
    //     int maxLen = s.length();
    //     String str=null;
    //     int max=0;

    //     for (int i = 0; i < maxLen; i++) {
    //         for (int j = i+1; j <= maxLen; j++) {
    //             String test = s.substring(i, j);
    //             if (isPalindrome(test)&&s.length()>max) {
    //                 str=s.substring(i, j);
    //                 max=Math.max(s.length(), max);
    //             }
    //         }
    //     }
    //     return str;
    // }

    // private boolean isPalindrome(String s) {
    //     if(s==null || s.length()==0) return false;
    //     int len = s.length();
    //     for (int i = 0; i <= (len/2)-1; i++) {
    //         if (s.charAt(i) != s.charAt(len-i-1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //法二 动态规划  TC:O(n^2)  SC:O(n^2)
    //初始状态，l=r 时，此时 dp[l][r]=true。
    //状态转移方程，dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。

    public String longestPalindrome(String s){
        if(s==null || s.length()<2) return s;
        
        int len = s.length();
        int maxStart = 0;  //最长回文串起点
        int maxEnd = 0;    //最长回文串终点
        int maxLen = 1;    //最长回文串长度

        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r)==s.charAt(l)&&((r-l)<=2 || dp[l+1][r-1])) {
                    dp[l][r]=true;
                    int curLen=r-l+1;
                    if (curLen>maxLen) {
                        maxLen=curLen;
                        maxStart=l;
                        maxEnd=r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }
}