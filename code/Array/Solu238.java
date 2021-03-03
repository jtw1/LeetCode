/**
 * @Description 238  除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * @date 2021/3/3 0003-10:53
 */
public class Solu238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int len=nums.length;
        int[] res=new int[len];
        res[0]=1;
        res[1]=nums[0];
        for (int i = 2; i < len; i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        int tmp=1;
        for (int i = len-2; i >= 0; i--) {
            tmp *= nums[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}
