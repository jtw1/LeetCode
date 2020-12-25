import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description [17] 电话号码的字符组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @date 2020/12/25 0025-10:27
 */
public class Sol17 {
    static final Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public static void main(String[] args) {
        String digits="256";
        List<String> res=letterCombinations(digits);
        System.out.println(res);
    }

    public static List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        backtrack(res,map,digits,0,new StringBuffer());
        return res;
    }

    /**
     * 回溯
     * @param res 主函数中要返回的结果
     * @param map  最开始定义的全局map，2~9对应的字母的map表
     * @param digits 给出的2~9组成的字符串
     * @param index 2~9组成的字符串对应的位置
     * @param tmp 结果中每一个字母组合
     */
    public static void backtrack(List<String> res, Map<Character, String> map, String digits, int index, StringBuffer tmp){
        if(index==digits.length()){
            res.add(tmp.toString());
        }else{
            char digit=digits.charAt(index);
            String letters=map.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                tmp.append(letters.charAt(i));
                backtrack(res,map,digits,index+1,tmp);
                tmp.deleteCharAt(index);
            }
        }
    }

}
