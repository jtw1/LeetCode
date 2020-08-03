package LeetCodeTest;
// [260] 只出现一次的数字 III
// https://leetcode-cn.com/problems/single-number-iii/description/
public class Solu260 {
    /**
     * 思路：设只出现一次的数是a,b，将数组的所有数字异或，最终结果即为a^b=s
     * 现在将数组分成两部分，一部分包含a;另一部分包含b,然后分别对两部分元素异或，每部分得到的结果即为出现一次的数
     * 找出a,b不同的特征，s中某一位为1，说明a,b对应那位不同，可以根据这个对数组分类
     * s&(-s)得到s最右边的1代表的数
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int s=0;
        int[] result = new int[2];
        if(nums==null || nums.length==0) return result;
        for (int num : nums) {
            s ^= num;
        }  //s即出现一次的两个数异或的结果
        int res = s&(-s);  //得到s最右边一位的1代表的数，a,b在这一位肯定不同，以此为标志，将数组分成两部分·，一部分有a，一部分有b
        for (int num : nums) {
            if((num&res)==0){
                result[0] ^= num;
            }else{
                result[1] ^= num;
            }
        }
        return result;
    }
}