/**
 * @Description [509] 斐波那契数列数 day
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @date 2021/1/4 0004-9:48
 */
public class Sol509 {
    //法一：记忆化，类似dp  TC:O(n) SC:O(1)
    public int fib(int n) {
        if(n<2) return n;
        int a=0,b=1;
        for(int i=2;i<=n;i++){
            int tmp=a+b;
            a=b;
            b=tmp;
        }
        return b;
    }
    //法二：通项公式
    //时空复杂度与 CPU 支持的指令集相关
    public int fib1(int n){
        double sqrt5=Math.sqrt(5);
        double fbN=Math.pow((1+sqrt5)/2,n)-Math.pow((1-sqrt5)/2,n);
        return (int)(fbN/sqrt5);
    }
}
