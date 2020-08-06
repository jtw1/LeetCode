package LeetcodeTest;
// [152] 乘积最大数组
// https://leetcode-cn.com/problems/maximum-product-subarray/
public class Solu152 {
    public int maxProduct(int[] nums){
        //dp  TC:O(n)  SC:O(1)
        /**
         * 算法分析：与53题不同的是，这里当前位置的最优解并不一定是由前一位置的最优解转移得到的，比如，如果当前数组中有偶数个负数，按照53题的解法就有问题
         * 假如数组当前数是负数，那么希望前一位置结尾的某个段的积也是负数，并且希望这个负数尽可能小（前一位置结尾的某一段乘积的最小值），那么负负得正就会更大
         * 假如数组当前数是正数，那么希望前一位置结尾的某个段的积也是正数，并且希望这个正数尽可能大（前一位置结尾的某一段乘积的最大值），那么正正得正就会更大
         * 由于第i个状态只和第i-1个状态相关，根据滚动数组思想，只用两个变量来维护第i-1时刻状态，一个维护maxF,一个维护minF
         */
        int maxF=nums[0],minF=nums[0],ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx=maxF,mn=minF;
            maxF=Math.max(Math.max(mn*nums[i], nums[i]), mx*nums[i]);
            minF=Math.min(Math.min(mx*nums[i], nums[i]), mn*nums[i]);
            ans=Math.max(maxF, ans);
        }
        return ans;
    }
}