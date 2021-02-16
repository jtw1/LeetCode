/**
 * @Description 65 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @date 2021/2/16-11:59
 */
public class Sol65 {
    public int add(int a, int b) {
        // 对于a,b中有负数的情况
        // 在计算机系统中，数值一律用 补码 来表示和存储。
        // 补码的优势：加法、减法可以统一处理（CPU只有加法器）。
        // 因此，以上方法 同时适用于正数和负数的加法 。
        int sum=0,carry=0;
        do {
            sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;
        }while(b!=0);
        return a;
    }
}
