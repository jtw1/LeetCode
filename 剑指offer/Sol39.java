/**
 * @Description 39 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @date 2021/1/21 0021-11:22
 */
public class Sol39 {
    public int majorityElement(int[] nums) {
        //TC:O(n) SC:O(1)   投票法
        /**
         * 用x记录上一次访问的值，votes表明当前值出现的次数，
         * 如果下一个值和当前值相同那么votes++；如果不同votes--，减到0的时候就要更换新的x值了，
         * 因为如果存在超过数组长度一半的值，那么最后x一定会是该值
         */
        int x=0,votes=0,count=0;
        for(int num:nums){
            if(votes==0) x=num;
            votes += num==x?1:-1;
        }
        //对不存在超过数组长度一半的数字的处理
        for(int num:nums){
            if(num==x) count++;
        }
        return count>nums.length/2?x:0;
    }
}
