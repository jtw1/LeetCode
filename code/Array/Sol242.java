/**
 * @Description [242] 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @date 2020/11/22-15:11
 */
public class Sol242 {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) return false;
        //法二
        //TC O(n)  SC O(26)
        //TC 48.42%  SC 78.32%
        int[] alpha=new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i)-'a']++;
            alpha[t.charAt(i)-'a']--;
        }
        for (int a : alpha) {
            if (a != 0) return false;
        }
        return true;

//        //法二
          //TC 64.37%  SC 81.66%
//        int[] res1 = getArray(s);
//        int[] res2 = getArray(t);
//        for (int i = 0; i < res1.length; i++) {
//            if(res1[i]!=res2[i]) return false;
//        }
//        return true;
    }

    private int[] getArray(String s){
        int[] res=new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)-'a']++;
        }
        return res;
    }
}
