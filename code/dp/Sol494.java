/**
 * @Description 494 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @date 2021/3/15 0015-11:12
 */
public class Sol494 {
    /**
     * TC:O(N*2000)  SC:O(N*2000)
     * dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。
     * 转移方程：dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]]
     * 也可以写成递推形式
     * dp[i][j + nums[i]] += dp[i - 1][j]
     * dp[i][j - nums[i]] += dp[i - 1][j]
     * 推导过程：dp[i][j]初始化时都是0，转移方程可写成
     * dp[i][j] += dp[i-1][j-nums[i]] (1)
     * dp[i][j] += dp[i-1][j+nums[i]] (2)
     * 在(1)中令j=j+nums[i],在(2)中令j=j-nums[i]
     * 可得转移方程的递推形式
     *
     * 由于数组中所有数的和不超过 1000，那么 j 的最小值可以达到 -1000，下标不允许是负数，所以先给第二维怎加1000
     *
     */
    public int findTargetSumWays1(int[] nums, int S){
        int[][] dp=new int[nums.length][2001];
        dp[0][nums[0]+1000]=1;
        dp[0][-nums[0]+1000]+=1;
        for (int i = 1; i < nums.length; i++) {
            // sum从-1000到1000，可以保证第二维下标始终为正
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i-1][sum+1000]>0){
                    dp[i][sum+1000+nums[i]] += dp[i-1][sum+1000];
                    dp[i][sum+1000-nums[i]] += dp[i-1][sum+1000];
                }
            }
        }
        return S>1000? 0:dp[nums.length-1][S+1000];
    }

    /**
     * 空间压缩  TC:O(N*2000)  SC:O(2000)
     */
    public int findTargetSumWays(int[] nums, int S){
        int[] dp=new int[2001];
        dp[nums[0]+1000]=1;
        dp[-nums[0]+1000]+=1;
        for (int i = 1; i < nums.length; i++){
            int[] next=new int[2001];
            for (int sum = -1000; sum <= 1000; sum++){
                if (dp[sum+1000]>0){
                    next[sum+1000+nums[i]] += dp[sum+1000];
                    next[sum+1000-nums[i]] += dp[sum+1000];
                }
            }
            dp=next;
        }
        return S>1000? 0:dp[S+1000];
    }

    /**
     * 01背包问题    dp
     * https://leetcode-cn.com/problems/target-sum/solution/yi-tao-kuang-jia-jie-jue-bei-bao-wen-ti-58wvk/
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        /**
         * 设正数部分和为s(p),负数部分和为s(n),nums数组的和为sum
         *           s(p)-s(n)=target
         * s(p)+s(n)+s(p)-s(n)=target+s(p)+s(n)
         * 2*s(p)=target+sum ==>  s(p)=(target+sum)/2
         * 问题转化为在nums数组中，是否存在一组数字，使其和为   (target+sum)/2
         */
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        // sum<target时，无论怎样分配正负号，都无法凑出结果为target的式子
        if(sum<target || (sum+target)%2==1) return 0;

        int w=(sum+target)/2;
        // dp[i] 表示和为 i 的 num 组合有 dp[i] 种。
        int[] dp=new int[w+1];
        dp[0]=1;   // 和为0的组合只有一种，那就是一个都不选
        for(int num:nums){
            // 从后往前遍历是为了防止dp[i-num]被覆盖
            for(int i=w;i>=num;i--){
                // 每个num只用一次   等式右边的dp[i]代表之前没用num时，和为i的组合
                // 对于元素之和等于 i - num 的每一种排列，在最后添加 num 之后即可得到一个元素之和等于 i 的排列，
                // 因此在计算 dp[i] 时，应该计算所有的 dp[i − num] 之和。
                dp[i]=dp[i]+dp[i-num];
            }
        }
        return dp[w];
    }
}
