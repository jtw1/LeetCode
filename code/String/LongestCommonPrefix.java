package LeetCodeTest;
// [14] 最长公共前缀
//https://leetcode-cn.com/problems/longest-common-prefix/description/
import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l=new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix1(new String[]{"flower","flover","flsed"}));
        System.out.println(l.longestCommonPrefix2(new String[]{"flower","flover","flsed"}));
        System.out.println(l.longestCommonPrefix3(new String[]{"flower","flover","flsed"}));
    }
    
    public String longestCommonPrefix1(String[] strs){
        if(strs.length==0||strs==null)  return "";   //先判断特殊情况，返回null
        String prefix=strs[0];                       //将字符串数组的第一个字符串赋给prefix 
        for (String s : strs) {
            while(s.indexOf(prefix)!=0)              
                  prefix=prefix.substring(0,prefix.length()-1);
        }
           //遍历字符串数组的每一个字符串，按顺序，如果prefix在其他字符串中不是从第一位开始的
           //（即在S中是否能找到prefix字符串，如果有，看是不是从第一位开始的）
           //如果不是从第一位开始的，将prefix字符串从最后切掉一位，直到跳出while循环
        return prefix;    //时间复杂度O(nm),当字符串数组里面有n个字符串，每个字符串平均长度为m
    }

    public String longestCommonPrefix2(String[] strs){
        if(strs.length==0||strs==null)  return "";   //先判断特殊情况，返回null
        Arrays.sort(strs);  //按照从小到大的顺序给strs排序，先比较每个字符串的第一个字符
                            //相同的话再比较第二个。。。如[abc,ac,abd],sort之后[abc,abd,ac]
        String word1=strs[0];
        String word2=strs[strs.length-1];
        while(word2.indexOf(word1)!=0)  word1=word1.substring(0,word1.length()-1);
        return word1;      //时间复杂度O(nmlogn),当字符串数组里面有n个字符串，每个字符串平均长度为m
    }

    public String longestCommonPrefix3(String[] strs){
        if(strs.length==0||strs==null)  return "";   //先判断特殊情况，返回null
        String ans=strs[0];                          //令最长公共前缀 ans 的值为第一个字符串，进行初始化
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if(ans.charAt(j)!=strs[i].charAt(j))   break;
            }
            ans=ans.substring(0,j);
        }  //遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
        return ans;   //时间复杂度O(mn)
    }
}