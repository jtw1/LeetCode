package qianzhuihe;

/**
 * @Description 724. 寻找数组的中心下标
 * https://leetcode-cn.com/problems/find-pivot-index/
 * @date 2021/3/21-11:13
 */
public class Sol724 {
    // 前缀和 TC:O(n)  SC:O(n)
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return 0;
        int preSum=0;
        for(int num:nums){
            preSum += num;
        }

        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            if(leftSum==(preSum-leftSum-nums[i])){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
