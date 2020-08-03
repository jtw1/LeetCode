package LeetCodeTest;
// [191] 位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/description/
public class Solu191 {
    public int hammingWeight(int n) {
        int count=0;
        //法一 n&1=0时，最右边一位是0；n&1=1时，最右边一位是1
        //TC:O(m),m为n的位数   SC:O(1)
        while (n!=0) {
            count += n&1;
            n >>= 1;
        }
        return count;

        //法二 n&(n-1) 结果即n得最右边的1变为0，其余不变
        //TC:O(1) SC:O(1)
        // int count=0;
        // while (n!=0) {
        //     n = n&(n-1);
        //     count++;
        // }
        // return count;

        //法三 TC:O(1) SC:O(1)
        // int count=0;
        // int mark=1;
        // for (int i = 0; i < 32; i++) {
        //     if ((n & (1<<i)) != 0) {
        //        count++; 
        //     }
        // }
        // return count;

        //法四
        // return n==0? 0:1+hammingWeight(n&(n-1));
    }
}