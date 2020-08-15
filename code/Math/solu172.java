package LeetCodeTest;
// [172] 阶乘后的零
// https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
// 解析  https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
// 找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5。
// 直接的，我们只需要判断每个累乘的数有多少个 5 的因子即可。
public class solu172 {
    public int trailingZeroes(int n) {
        int count=0;
        while (n>0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}