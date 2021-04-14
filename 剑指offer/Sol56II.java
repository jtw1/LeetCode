/**
 * @Description 56-II 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * https://www.cnblogs.com/MyStringIsNotNull/p/12585218.html
 * @date 2021/2/9-10:45
 */
public class Sol56II {
    public int singleNumber(int[] nums) {
        /**
         * 有限状态机
         * 我们可以一次分析32bit的int的各个位在数组的各个数字中出现的次数。
         * 实际上，我们只需要记录对应位出现的次数为0、1、2次的情况，
         * 当对应位出现次数为3的时候，我们便可以将该位出现的次数置为0,重新开始进行计数。
         * 由于int型中的各个二进制位出现的次数为3进制的，为此我们需要两个位来记录各个位出现的次数
         * 由于是先计算 one ，因此应在新 one 的基础上计算 two 。
         */
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        //遍历完所有数字后，各二进制位都处于状态 00 和状态 01 （取决于 “只出现一次的数字” 的各二进制位是 1 还是 0 ），
        // 而此两状态是由 ones 来记录的（此两状态下 twos 恒为 0 ），因此返回 ones 即可。
        return ones;
    }

    public int singleNumber1(int[] nums){
        int[] bitSum=new int[32];
        int len=nums.length;
        for (int i = 0; i < nums.length; i++) {
            int bitMask=1;
            for (int j = 31; j >= 0; j--) {
                int bit=nums[i] & bitMask;
                if(bit!=0) bitSum[j]++;
                bitMask <<= 1;
            }
        }
        int res=0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitSum[i]%3;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int[] bitSum=new int[32];
        int len=nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= 31; j++) {
                bitSum[j] += nums[i]&1;
                nums[i]>>>=1;
            }
        }
        int res=0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= bitSum[31-i]%3;
        }
        return res;
    }
}
