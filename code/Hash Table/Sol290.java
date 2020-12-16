import java.util.HashMap;
import java.util.Map;

/**
 * @Description [290] 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 * @date 2020/12/16 0016-9:53
 */
public class Sol290 {
    public boolean wordPattern(String pattern, String s){
        //TC:O(m+n)  SC:O(m+n)
        String[] arrStr=s.split(" ");
        if(pattern.length()!=arrStr.length) return false;
        Map<Character,String> chToStr=new HashMap<>();
        Map<String,Character> strToCh=new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if(!chToStr.containsKey(pattern.charAt(i))){
                if(strToCh.containsKey(arrStr[i])) return false;
                chToStr.put(pattern.charAt(i),arrStr[i]);
                strToCh.put(arrStr[i],pattern.charAt(i));
                continue;
            }
            if(!chToStr.get(pattern.charAt(i)).equals(arrStr[i])) return false;
        }
        return true;
    }
}
