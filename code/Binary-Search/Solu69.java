package LeetCodeTest;
// [69] x 的平方根
// https://leetcode-cn.com/problems/sqrtx/description/
//import java.lang.Math.*;

public class Solu69 {
    public int mySqrt(int x) {
        //二分法
        /*
        if (x<=0)   return 0;
        int l=0,r=x,ans =-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if ((long)mid*mid <= x) {
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;*/

        //牛顿法
        /**
         * 即求解f(a)=a^2-x的根的问题，在曲线上任取一点A(a0,f(a0)),该点的切线L0斜率f'(a)
         * 切线与X轴的交点为(a0-f(a0)/f'(a0),0),
         * 再在曲线上取点B(a1,f(a1)),其中a1=a0-f(a0)/f'(a0),过点B作曲线的切线L1
         * 切线L1与X轴的交点为(a1-f(a1)/f'(a1),0),
         * 切线的斜率越来越小，即切线越来越平，与X轴交点越来越接近曲线的零点
         * 所以多次迭代，直到an^2<x时，an即为所求（画图更好理解）
         */
        if(x==0) return 0;
        long a=x;
        while (a*a>x) {
           a = 1/2 * (a+x/a);  
        }
        return (int)a;
    }
}