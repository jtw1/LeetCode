/**
 * @Description 680 验证回文字符串 Ⅱ
 * @date 2021/5/26 0026-9:30
 */
public class Sol680II {
    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        for(int left=0,right=s.length()-1;left<right;left++,right--){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
