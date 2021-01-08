/**
 * @Description [15] 二进制1的个数 p100
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @date 2021/1/8 0008-9:39
 */
public class Sol15 {
    //法一，不断和对应位的1做与运算
    public int hammingWeight1(int n) {
        int count=0;
        int flag=1;
        while(n!=0){
            count += n&flag;
            n >>>= 1;
        }
        return count;
    }

    //法二：n&(n-1)   n的最右边的1变为0
    public int hammingWeight(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}

