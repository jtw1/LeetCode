package LeetCodeTest;
// [171] Excel表列序号
// https://leetcode-cn.com/problems/excel-sheet-column-number/description/
public class Solu171 {
    public int titleToNumber(String s) {
        if(s==null) return 0;
        int n=1;
        int number=0;
        for (int i = s.length()-1; i >= 0; i--) {
            number += (s.charAt(i)-'A'+1)*n;
            n *= 26;
        }
        return number;
    }
}