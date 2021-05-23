/**
 * @Description 377 组合总和IV
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * @date 2021/5/23-15:48
 */
public class Sol377 {
    /**
     * 完全背包，且考虑顺序，外循环背包(target)，内循环物品(nums数组)
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j] && (dp[i]+dp[i-nums[j]])<Integer.MAX_VALUE){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
