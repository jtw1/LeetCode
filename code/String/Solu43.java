package LeetcodeTest;
// [43] 字符串相乘
// https://leetcode-cn.com/problems/multiply-strings/
public class Solu43 {
    public String multiply(String num1, String num2){
        //TC:O(m*n)   SC:O(m+n)
        //乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
        //num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int[] res = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int n1=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int n2=num2.charAt(j)-'0';
                int sum = res[i+j+1]+n1*n2;
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0 && res[i]==0)  continue;    //最高位是0，则跳过继续执行
            result.append(res[i]);
        }
        return result.toString();
    }
}