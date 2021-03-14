import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 438. 找到字符串中所有字母异位词，滑动窗口 + 数组/双指针
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @date 2021/3/14-11:11
 */
public class Sol438 {
    // TC:O(n)  SC:O(1) 7ms
    public List<Integer> findAnagrams(String s, String p){
        /**
         * 因为字符串中的字符全是小写字母，可以用长度为26的数组记录字母出现的次数
         * 设sLen = len(s), pLen = len(p)。记录p字符串的字母频次pArr，和s字符串前m个字母频次sArr
         * 若pArr和sArr相等，则找到第一个异位词索引 0
         * 继续遍历s字符串索引为[m, n)的字母，在sArr中每次增加一个新字母，去除一个旧字母
         * 判断pArr和sArr是否相等，相等则在返回值res中新增异位词索引 i - m + 1
         */
        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()<p.length()) return res;
        int sLen = s.length(),pLen = p.length();
        int[] sArr=new int[26];
        int[] pArr=new int[26];
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i)-'a']++;
            pArr[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(sArr,pArr)) res.add(0);
        for (int i = pLen; i < sLen; i++) {
            // 移除sArr中s的第i-pLen个字符
            sArr[s.charAt(i-pLen)-'a']--;
            sArr[s.charAt(i)-'a']++;
            if (Arrays.equals(sArr,pArr)) res.add(i-pLen+1);
        }
        return res;
    }

    // 自己写的  1147ms
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()<p.length()) return res;
        int len = p.length();
        for(int i=0;i<s.length()-len;i++){
            String tmp=s.substring(i,i+len);
            if(isAnagrams(tmp,p)) res.add(i);
        }
        if(isAnagrams(s.substring(s.length()-len),p)) res.add(s.length()-len);
        return res;
    }
    private boolean isAnagrams(String s, String p){
        int len=s.length();
        int[] sArr=new int[26];
        int[] pArr=new int[26];
        for(int i=0;i<len;i++){
            sArr[s.charAt(i)-'a']++;
            pArr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(sArr[i]!=pArr[i]) return false;
        }
        return true;
    }
}
