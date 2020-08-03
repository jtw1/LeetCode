package LeetCodeTest;
// [137] 只出现一次的数字 II
// https://leetcode-cn.com/problems/single-number-ii/description/
public class Solu137 {
    public int singleNumber(int[] nums) {
        //把每个数都看成32位二进制数，该数组除了某个元素只出现一次以外，其余每个元素均出现了三次。每一位二进制上1累加起来是3n或3n+1
        //如果情况是该数组除了某个元素只出现一次以外，其余每个元素均出现了k次,只需把cnt%3!=0改为cnt%k!=0
        int ret=0;
        for (int i = 0; i < 32; i++) {
            int mask = 1<<i;
            int cnt=0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]&mask)!=0) {
                    cnt++;  //记录整个数组每个数二进制第一位上1的个数
                }
            }
            //现在默认32位二进制数ret每一位都是0,cnt%3!=0时，表示单独一个的那个数该位为1，
            if (cnt%3!=0) {
                ret |= mask;
            }
        }
        return ret;

        //逻辑电路方法,为了使出现三次的数抵消，只保留出现一次的数，
        //设有三个状态：00，01，10，当输入为0时，下一状态不变，即00-00，01-01，10-10，当输入为1时，00-01，01-10，10-00，
        //再画卡诺图，即可得到逻辑表达式
        // int x=0;  //状态为xy
        // int y=0;
        // for (int i : nums) {
        //     y= ~x & (y^i);
        //     x= ~y & (x^i);
        // }
        // return y; //返回y是因为只出现了一次的那个数字会带来一次状态改变，对应的记录位y的变化，即00->01，所以b的值即为这个数字
    }
}