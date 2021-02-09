/**
 * @Description 56-I 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @date 2021/2/9-9:42
 */
public class Sol56I {
    public int[] singleNumbers(int[] nums) {
        int res=0;
        //最后异或的结果是两个只出现一次的数异或的结果
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        //得到res最后一位1所代表的数，第n位
        int firstBitOf1=res&(-res);
        int nums1=0,nums2=0;
        //根据第n位是否是1 将原数组分为两组数，两个只出现一次的数分别出现在两组数中
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & firstBitOf1)==0){
                nums1 ^= nums[i];
            }else {
                nums2 ^= nums[i];
            }
        }
        return new int[]{nums1,nums2};
    }
}
