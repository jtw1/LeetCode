import java.util.List;

/**
 * @Description 524. 通过删除字母匹配到字典里最长单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * @date 2021/5/26 0026-10:22
 */
public class Sol524 {
    // TC:O(nx) SC:O(x)   n 是列表 dictionary 中字符串的数目， x 是字符串平均长度
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord="";
        for(String target:dictionary){
            int l1=longestWord.length(),l2=target.length();
            /**
             * 题目要求长度最长且字典序最小，下面的判断条件代表的含义：
             *    当前longestWord长度大于target长度(即：满足长度相对较长)
             *    长度相等时，longestWord字典序小于target字典序(即满足字典序较小)
             * 满足这个条件时，说明当前target肯定不符合，所以继续遍历下一个
             */
            if(l1>l2 || (l1==l2 && longestWord.compareTo(target)<0)){
                continue;
            }
            if(isSubStr(s,target)){
                longestWord=target;
            }
        }
        return longestWord;
    }

    /**
     * 判断target是否是s的子序列
     * @param s
     * @param target
     * @return
     */
    private boolean isSubStr(String s,String target){
        int i=0,j=0;
        while(i<s.length() && j<target.length()){
            if(s.charAt(i)==target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
    }
}
