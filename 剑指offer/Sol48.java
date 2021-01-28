import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description 48 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @date 2021/1/28 0028-10:46
 */
public class Sol48 {
    public int lengthOfLongestSubstring(String s) {
        /**
         * dp[j] 代表以字符 s[j] 为结尾的 “最长不重复子字符串” 的长度。
         * 转移方程： 固定右边界 j ，设字符 s[j] 左边距离最近的相同字符为 s[i] ，即 s[i] = s[j] 。
         *
         * 当 i<0 ，即 s[j] 左边无相同字符，则 dp[j] = dp[j-1] + 1 ；
         * 当 dp[j−1]<j−i ，说明字符 s[i] 在子字符串 dp[j−1] 区间之外 ，则 dp[j]=dp[j−1]+1 ；
         * dp[j−1]≥j−i ，说明字符 s[i] 在子字符串 dp[j−1] 区间之中 ，则 dp[j] 的左边界由 s[i] 决定，即 dp[j]=j−(i+1)+1 ；
         */
        //哈希表（统计 各字符最后一次出现的索引位置 ）+dp   TC: O(n)  SC:O(1)
        // 左边界 i 获取方式： 遍历到 s[j] 时，可通过访问哈希表dic[s[j]] 获取最近的相同字符的索引 i 。
        Map<Character,Integer> dic=new HashMap<>();
        int res=0,tmp=0;
        for (int j = 0; j < s.length(); j++) {
            int i=dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j),j);
            tmp=(tmp<j-i)?tmp+1:j-i;
            res=Math.max(res,tmp);
        }
        return res;
    }
    //哈希表+双指针
    public int lengthOfLongestSubstring1(String s){
        Map<Character,Integer> dic=new HashMap<>();
        int res=0,i=-1;
        for (int j = 0; j < s.length(); j++) {
            i=Math.max(i,dic.getOrDefault(s.charAt(j),-1));
            dic.put(s.charAt(j),j);
            res=Math.max(res,j-i);
        }
        return res;
    }
}
