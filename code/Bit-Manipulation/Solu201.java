package LeetCodeTest;
// [201] 数字范围按位与
// https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/description/

//超nice的题解：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--41/
public class Solu201 {
    public int rangeBitwiseAnd(int m, int n) {
        //对[m,n]所有数进行与操作后，结果即为所有数字（二进制）的公共前缀，m最小，二进制表示最短，n最大，二进制表示最长，所有数字的公共前缀即m和n两个数的公共前缀
        //TC:O(1)     SC:O(1)
        int move=0;
        //m=n时退出循环
        while (m<n) {
            m=m>>1;
            n=n>>1;
            move++;  //记录移动次数
        }
        return m<<move;

        //TC:O(1)     SC:O(1)
        //利用n&(n-1) 把n最右边的1置零
        //m=n时退出循环
        // while (m<n){
        //     n &= (n-1);
        // }
        // return n;
    }
}