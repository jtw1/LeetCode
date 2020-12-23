import java.util.HashMap;
import java.util.Map;

/**
 * @Description [387] 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @date 2020/12/23 0023-10:42
 */
public class Sol387 {

    //法三 2ms beat 100%
    public int firstUniqChar2(String s){
        int min = s.length();
        for (int i = 0; i < 26; i++) {
            int index = s.indexOf('a' + i);
            //字符串中存在('a' + i) 且 'a' + i 在s中仅出现一次 且index < min时，就进入if判断，
            // 第二个条件判断的是'a' + i 在s中仅出现一次
            // 当找到第一个只出现一次的字母ch之后，min即为ch的下标，假如没有仅出现一次的字母，整个循环过程不会进入if判断
            // 后面的遍历 index都会大于min，不再进入if判断
            if ((index != -1) && (index == s.lastIndexOf('a' + i)) && (index < min)) {
                min = s.indexOf('a' + i);
            }
        }
        return min == s.length() ? -1 : min;
    }

    //法一  33%
    public int firstUniqChar(String s) {
        //TC:O(n)  SC:O(x)  x<26   35ms
        if(s==null || s.length()==0) return -1;
        Map<Character, Integer> map=new HashMap<>();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < len; i++){
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
    //与一类似，数组实现  6ms
    public int firstUniqChar1(String s){
        if(s==null || s.length()==0) return -1;
        int[] map=new int[26];
        int len=s.length();
        for (int i = 0; i < len; i++) {
            map[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < len; i++){
            if(map[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

}
