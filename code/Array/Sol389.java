import java.util.HashMap;
import java.util.Map;

/**
 * @Description [389] 找不同 day
 * https://leetcode-cn.com/problems/find-the-difference/
 * @date 2020/12/18 0018-9:11
 */
public class Sol389 {
    //法一 位运算  如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符
    //TC:O(n) SC:O(1)
    public char findTheDifference(String s, String t){
        int ret=0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char)ret;
    }

    //法二 计数
    //TC:O(n) SC:O(1)
    public char findTheDifference1(String s, String t) {
        if(s=="" || t=="") return s==""? t.charAt(0):s.charAt(0);

        int[] sMap = new int[26];
        int[] tMap = new int[26];
        int i=0;
        for (i = 0; i < s.length(); i++) {
            sMap[s.charAt(i)-'a']++;
        }
        for (i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)-'a']++;
        }

        for (i = 0; i < 26; i++) {
            if(sMap[i]!=tMap[i]) break;
        }
        return (char)(i+'a');
    }
}
