package LeetcodeTest;
// 415 字符串相加
// https://leetcode-cn.com/problems/add-strings/
public class Solu415 {
    public String addStrings(String num1, String num2){
        //TC:O(max(num1.length(),num2.length()))   SC:O(max(num1.length(),num2.length()))
        int len1=num1.length()-1,len2=num2.length()-1,add=0;
        StringBuffer ans = new StringBuffer();
        //对add!=0的判断主要是考虑到加到最高位时，还有进位，避免了跳出while循环之后还要执行别的判断
        while (len1>=0||len2>=0||add!=0) {
            int x=(len1>=0?num1.charAt(len1)-'0':0);
            int y=(len2>=0?num2.charAt(len2)-'0':0);
            int sum=x+y+add;

            ans.append(sum%10);
            add=sum/10;

            len1--;
            len2--;
        }

        return ans.reverse().toString();
    }
}