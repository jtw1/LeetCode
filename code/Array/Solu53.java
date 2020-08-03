package LeetCodeTest;
//[53] 最大子序和
// https://leetcode-cn.com/problems/maximum-subarray/description/
public class Solu53 {
    public int maxSubArray(int[] nums) {
        //先假设dp[i]是以nums[i]结尾的一段最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1]+nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = (dp[i]>max? dp[i]:max);
        }
        return max;
        
        //法二
        // int max = nums[0];
        // for (int i = 1; i < dp.length; i++){
        //     if (nums[i-1] > 0) {
        //         nums[i] = nums[i-1]+nums[i];
        //     } 
        //     max = (nums[i]>nums[i-1]? nums[i]:nums[i-1]);
        // }

    }
}