/**
 * @Description 42 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @date 2021/1/25 0025-14:28
 */
public class Sol42 {
    //TC:O(n) SC:O(1)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > 0) {
                nums[i] = nums[i-1]+nums[i];
            }
            max = (nums[i]>max? nums[i]:max);
        }
        return max;
    }
    //TC:O(n) SC:O(n)
    public int maxSubArray1(int[] nums) {
        // dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
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
    }
}
