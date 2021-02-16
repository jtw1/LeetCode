/**
 * @Description 64 求1+2+3+...+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @date 2021/2/16-11:03
 */
public class Sol64 {
    int res=0;
    public int sumNums(int n) {
        // 通常递归的时候会利用条件判断语句来决定递归的出口，
        // 由于题目限定不能使用条件判断语句，可利用逻辑运算的短路性质
        // 对于x= A && B,若A为false，则x为false，B不会执行
        // 对于x= A || B,若A为true，则x为true，B不会执行
        boolean x=n>1 && sumNums(n-1)>0;
        res += n;
        return res;
    }

    // 法二 快速乘

}
