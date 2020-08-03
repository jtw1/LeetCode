package LeetCodeTest;
// [50] Pow(x, n)
// https://leetcode-cn.com/problems/powx-n/description/
public class Solu50 {
    public double myPow(double x, int n) {
        long m=n;
        return m>=0? quickMul(x, m):1.0/quickMul(x, -m);
    }
    //迭代法  TC:O(logn)   SC:O(1)
    /**
     * 任意无符号数n可以表示成2的任意次幂累加
     * 所以x^n=x^(2^i) * x^(2^j) * x^(2^m)...
     * 幂取决于n的二进制表示
     */
    private double quickMul(double x,long n){
        double ans=1.0;
        double x_contribute = x;//初始贡献值
        while (n>0) {
            if(n%2==1){
                //n的二进制表示最低为为1，需要计入贡献
                ans *= x_contribute;
            }
            //因x^(2^(i+1))=[x^(2^i)]^2,所以n每右移一位，都要将贡献平方
            x_contribute *= x_contribute;
            n /= 2;//舍弃n的二进制表示的最低位,相当于右移一位
        }
        return ans;
    }

    //递归法  TC:O(logn)   SC:O(logn)
    public double quickMul1(double x, long N) {
        if(N==0) return 1.0;
        double y = quickMul(x, N/2);
        return N%2==0? y*y : y*y*x;
    }
}