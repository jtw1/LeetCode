/**
 * @Description 44 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @date 2021/1/27 0027-9:00
 */
public class Sol44 {
    public int findNthDigit(int n) {
        if(n<=9) return n;

        int digit=1;  // n所在数字的位数
        long start=1; // 数字范围开始的第一个数
        long count=9; // 占多少位

        while(n>count){
            n -= count;
            digit++;
            start *= 10;
            count = digit*start*9;
        }
        long num=start+(n-1)/digit;    //序列的第一位是0，所以n-1
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
