import java.util.HashMap;
import java.util.Map;

/**
 * @Description [205] 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * @date 2020/12/27-14:46
 */
public class Sol205 {
    //法二 数组 3ms beats 98.51%
    public boolean isIsomorphic(String s, String t) {
        int len=s.length();
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        //绝大多数计算机的一个字节是8位，取值范围是0~255  ASCII范围
        int[] preIndexOfs=new int[256];
        int[] preIndexOft=new int[256];

        for (int i = 0; i < len; i++) {
            if(preIndexOfs[cs[i]]!=preIndexOft[ct[i]]) return false;
            preIndexOfs[cs[i]]=i+1;
            preIndexOft[ct[i]]=i+1;
        }
        return true;
    }
    //法二 哈希表 29ms  beats 8.89%
    public boolean isIsomorphic1(String s, String t) {
        int len=s.length();
        Map<Character,Character> s2t=new HashMap<>();
        Map<Character,Character> t2s=new HashMap<>();
        for(int i=0;i<len;i++){
            char x=s.charAt(i), y=t.charAt(i);
            if((s2t.containsKey(x) && s2t.get(x)!=y) || (t2s.containsKey(y) && t2s.get(y)!=x)) return false;

            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
