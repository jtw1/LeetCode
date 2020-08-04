package LeetCodeTest;
//[198] 打家劫舍
// https://leetcode-cn.com/problems/house-robber/description/
public class Solu198 {
    public int rob(int[] nums) {
        if(nums.length==0 || nums==null)   return 0;
        if(nums.length==1)   return nums[0];
        
        //法一
        // int[] dp = new int[nums.length+1];
        // dp[0] = 0;
        // dp[1] = nums[0];
        // /**
        //  * 小偷走到第i间房时，有两种情况
        //  * 在第i间房偷，那前面一家(i-1)我就不能偷，我当前偷到的最大值就是偷完前(i-2)家的最大值加上我偷这一家的钱。
        //  * 如果不偷，我当前偷到的最大值就是偷完前(i-1)家的最大值，然后我就去下一家再看看
        //  * 然后比较出两种情况的最大值
        //  */
        // for (int i = 2; i < dp.length; i++) {
        //     dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        //     //dp[i] = (dp[i-2]+nums[i-1]>dp[i-1]?dp[i-2]+nums[i-1]:dp[i-1]);
        // }
        // return dp[nums.length];


        //法二空间优化改进
        int first=nums[0],second=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp=second;
            second=Math.max(nums[i]+first,temp);
            first = temp;           
        }
        return second;
    }
}