/**
 * @Description 16 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @date 2021/1/9-14:02
 */
public class Sol16 {
    public static void main(String[] args) {
        Sol16 test=new Sol16();
        double res=test.myPow(2.00000 ,-2147483648);
        System.out.println(res);
    }
    //TC:O(logn) SC:O(1)
    public double myPow1(double x, int n) {
        if(x==0) return 0;
        long b=n;
        double res=1.0;
        if(n<0){
            x=1/x;
            b=-b;
        }
        while(b>0){
            if((b&1)==1) res *= x;
            x *= x;
            b >>=1;
        }
        return res;
    }


    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if (n<0){
            return 1/(x*myPow(x,-n-1));
        }else if (n%2==1){
            return x*myPow(x,n-1);
        }else{
            return myPow(x,n>>1);
        }
    }
//    private double powWithUnsignedExponent(double x, long n){
//        if(n==0) return 1.0;
//        if(n==1) return x;
//        if(Double.doubleToLongBits(x) == Double.doubleToLongBits(1.00000)) return x;
//        double result=powWithUnsignedExponent(x,n>>1);
//        result *= result;
//        if((n&1)==1) result *= x;
//        return result;
//    }
}
