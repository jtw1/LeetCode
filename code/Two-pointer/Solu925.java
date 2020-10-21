//[925] 长按键入
// https://leetcode-cn.com/problems/long-pressed-name/
// https://leetcode-cn.com/problems/long-pressed-name/solution/chang-an-jian-ru-by-leetcode-solution/


class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed==null || typed.length()==0) return false;
        int i=0,j=0;
        //TC:O(n+m) SC:O(1)
        while(j<typed.length()){
            //当name[i]=typed[j] 时，说明两个字符串存在一对匹配的字符，此时将i,j 都加 1。
            if(i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            //否则，如果typed[j]=typed[j−1]，说明存在一次长按键入，此时只将 j 加 1。
            else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        //最后，如果i=name.length，说明name 的每个字符都被匹配了。
        return i==name.length();
    }
}
