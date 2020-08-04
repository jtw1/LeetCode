package LeetCodeTest;
// [70] 爬楼梯
// https://leetcode-cn.com/problems/climbing-stairs/description/
public class Solu70 {
    public int climbStairs(int n) {
        if (n==1 || n==2 || n==0) {
           return n; 
        }
        /**
         * 时间复杂度和空间复杂度都是O(n)
         * 动态规划思想
         * 总共n阶楼梯，每次可以走一步或两步，设n阶楼梯总共的走法为f(n)
         * 第一次跨1步时，后面n-1阶台阶有f(n-1)种走法
         * 第一次跨2步时，后面n-2阶台阶有f(n-2)种走法
         * 所以f(n)=f(n-1)+f(n-2)
         * 对应下面就是temp = a+b,n每增加1，啊，a,b分别后移一位对应原来的b,temp
         */
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;


        //递归思想
        //return climbStairs(n-1)+climbStairs(n-2);

        /*
         * 斐波那契公式
         * 时间复杂度：O(log(n))，pow方法将会用去 log(n)的时间
         * （a^n=a^n/2 * a^n/2 = a^n/4 * a^n/4 * a^n/4 * a^n/4 = .....  所以时间复杂度O(log(n))）。
         *  空间复杂度：O(1)O(1)，使用常量级空间。
         */
        // double sqrt5=Math.sqrt(5);
        // double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        // return (int)(fibn/sqrt5);
    }
}