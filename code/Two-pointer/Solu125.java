package LeetCodeTest;
// [125] 验证回文串
// https://leetcode-cn.com/problems/valid-palindrome/description/
public class Solu125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if(s==null || len==0) return true;
        int begin=0;
        int end=len-1;
        while(begin<end){
            while(!isIllegal(s.charAt(begin)) && begin<end){
                begin++;
            } 
            while(!isIllegal(s.charAt(end)) && begin<end){
                end--;
            }
            
            if (begin < end) {
                int difference=Math.abs(s.charAt(begin)-s.charAt(end));
                if(difference==0 || difference==32){
                    begin++;
                    end--;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    //判断字符是否是数字或字母
    private boolean isIllegal(char c){
        if ((c>=65&&c<=90) || (c>=97&&c<=122) || (c>=48&&c<=57)) {
            return true;
        }
        return false;
    }
     
    //法二 TC:O(s)  SC:O(s)
    // StringBuffer sgood = new StringBuffer();
    // int length = s.length();
    // for (int i = 0; i < length; i++) {
    //     char ch = s.charAt(i);
    //     if (Character.isLetterOrDigit(ch)) {
    //         sgood.append(Character.toLowerCase(ch));
    //     }
    // }
    // StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
    // return sgood.toString().equals(sgood_rev.toString());
}