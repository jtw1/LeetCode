//416 分割等和子集
// https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/

class Solution {
    public boolean canPartition(int[] nums) {
        int len=nums.length;
        if(len==0) return false;
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        if((sum&1)==1) return false;
        //TC:O(NC)  SC(N)
        //N是数组元素个数  C是数组和的一半
        int target=sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] =true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
