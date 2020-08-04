package LeetCodeTest;
//[58] 最后一个单词的长度
//https://leetcode-cn.com/problems/length-of-last-word/description/
public class Solu58 {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end>=0 && s.charAt(end)==' ') end--;
        if (end<0)    return 0;

        int start = end;
        while(start>=0 && s.charAt(start)!=' ')  start--;
        return end-start;
    }

    public int lengthOfLastWord1(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int end = s.length()-1;
        while (end>=0 && s.charAt(end)==' ') {
            end--;
        }
        if (end<0)    return 0;
        for (int i = end-1; i >= 0; i--) {
            if (s.charAt(i)==' ') {
                return end-i;
            }
        }
        return end+1;
    }
}