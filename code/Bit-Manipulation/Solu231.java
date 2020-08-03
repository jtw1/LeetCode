package LeetCodeTest;
// [231] 2的幂
// https://leetcode-cn.com/problems/power-of-two/description/
public class Solu231 {
    public boolean isPowerOfTwo(int n) {
        //TC O(logn)  SC:O(1)
        if(n<=0) return false;
        while (n%2==0) n /= 2;
        return n==1;
        

        //TC O(1)  SC:O(1)
        //计算机中数字都是以补码形式存在的，0和正数的补码是其本身，负数的补码等于反码+1
        //x&(-x)可以得到x的二进制表示的最右边的1
        //根据这个性质，2的任意次幂的二进制表示只有一位是1，其余都是0
        //通过判断x&(-x)==x?可知其是否是2的幂
        // if(n<=0) return false;
        // long x = (long)n;
        // return (x&(-x))==x;

        //TC O(1)  SC:O(1)
        //通过x&(x-1) 将最右边的1设置为0
        //看x&(x-1)是否为0
        // if(n<=0) return false;
        // long x = (long)n;
        // return (x&(x-1))==0;
    }
}