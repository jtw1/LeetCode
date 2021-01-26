import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 50 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @date 2021/1/26 0026-11:11
 */
public class Sol50 {
    public char firstUniqChar(String s) {
        //哈希表   TC:O(n)  SC:O(n)
        if(s==null || s.length()==0) return ' ';
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1) return s.charAt(i);
        }
        return ' ';
    }
    //有序哈希表   TC:O(n)  SC:O(1)
    public char firstUniqChar1(String s){
        if(s==null || s.length()==0) return ' ';
        Map<Character, Boolean> dic=new LinkedHashMap<>();
        char[] sc=s.toCharArray();
        //第一个只出现一个的字符，value值为true
        for(char c:sc){
            dic.put(c,!dic.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> d:dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //数组   TC:O(n)  SC:O(1)
    public char firstUniqChar2(String s){
        if(s==null || s.length()==0) return ' ';
        int[] sc=new int[26];
        for (int i = 0; i < s.length(); i++){
            sc[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if(sc[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}
