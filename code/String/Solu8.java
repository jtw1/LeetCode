/**
 * @Description 8 字符串转换整数 与剑指offer67相同
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @date 2021/2/18-11:55
 */
public class Solu8 {
    public static void main(String[] args) {
        int a=myAtoi("4193 with words");
    }
    public static int myAtoi(String s) {
        if(s==null || s.length()==0) return 0;
        int res=0,border=Integer.MAX_VALUE/10;
        int  i=0,sign=1,len=s.length();
        while (s.charAt(i)==' '){
            if(++i == len) return 0;
        }
        if(s.charAt(i)=='-') sign=-1;
        if(s.charAt(i)=='-' || s.charAt(i)=='+') i++;
        for (int j = i; j < len; j++) {
            if(s.charAt(j)<'0' || s.charAt(j)>'9') break;
            if(res>border || res==border && s.charAt(j)>'7')
                return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=res*10+(s.charAt(j)-'0');
        }
        return res*sign;
    }
}
