import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description [139] 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @date 2021/1/2-16:17
 */
public class Sol139 {
    public boolean wordBreak(String s, List<String> wordDict){
        //我们定义 dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
        // TC:O(n^2)  SC:O(n)
        Set<String> wordDictSet=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;  //表示空串且合法
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
