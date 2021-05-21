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


    public boolean canPartition1(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        int w=sum/2;
        boolean[] dp=new boolean[w+1];    //dp[i]表示是否存在和为i的元素  存在为true    否则false
        dp[0]=true;
        for(int num:nums){
            for(int i=w;i>=num;i--){
                //dp[i-num]是上一轮得出的结果，为了防止被覆盖，所以i从后往前遍历，
                // 这样每次计算dp[i]时，用的dp[i-num]都是上一轮的（即未更新的）
                // 如果是从前往后遍历，用的dp[i-num]都是在这一轮更新过的，会产生错误
                dp[i] = dp[i]||dp[i-num];
            }
        }
        return dp[w];
    }
}
