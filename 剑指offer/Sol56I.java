/**
 * @Description 56-I 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @date 2021/2/9-9:42
 */
public class Sol56I {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,5,2};
        int[] res=singleNumbers(nums);
        for (int tmp : res) {
            System.out.print(tmp+" ");
        }
    }
    public static int[] singleNumbers(int[] nums) {
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
            //这里的判断条件只能设置成  ==0 或 !=0 ,不能设置成 ==1，因为firstBitOf1虽然只有一位是1，但这个1不一定在最低位，
            // 即(nums[i] & firstBitOf1)的结果除了等于0，还有很多种
            // 以本题数组为例，firstBitOf1=100，数组：[01,010,101,010]  判断条件如果设置成 ==1，nums1就一直是0了
            if((nums[i] & firstBitOf1)!=0){
                nums1 ^= nums[i];
            }else {
                nums2 ^= nums[i];
            }
        }
        return new int[]{nums1,nums2};
    }
}
