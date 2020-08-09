package LeetCodeTest;

import java.util.HashSet;
import java.util.Set;

// [3] 无重复字符的最长子串
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
public class solu3 {
    public int lengthOfLongestSubstring(String s) {
        //TC:O(n)   SC:O(m) m为字符串中可能出现的字符集个数
        
        //哈希集合，记录每个字符是否出现过
        Set<Character> list = new HashSet<>();
        int n=s.length();
        //右指针，初始值为-1，相当于在字符串左边界的左侧，还没开始移动,最长字串初始长度为0
        int rk=-1,ans=0;
        for (int i = 0; i < n; i++) {
            //左指针向右移动一格，就移除一个字符
            if (i!=0) {
                list.remove(s.charAt(i-1));
            }
            //不断移动右指针
            // 移动到右端点的情况，当rk+1=n时，此时rk=n-1,也就是前一次循环执行"rk++"之后的值，也等于rk+1，正好是右端点，所以不存在漏掉最后一个字符的情况
            while (rk+1<n && !list.contains(s.charAt(rk+1))) {
                list.add(s.charAt(rk+1));
                rk++;
            }
            //第i到rk个字符是一个极长的无重复字符字串
            ans=Math.max(ans, rk-i+1);
        }
        return ans;
    }
    
    //判断一个字符串是否含有重复字符
    // public boolean isRepeated(String s){
    //     HashSet<Character> list = new HashSet<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c=s.charAt(i);
    //         if (list.contains(c)) {
    //             return false;
    //         }
    //         list.add(c);
    //     }
    //     return true;
    // }
}