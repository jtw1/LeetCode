/**
 * @Description 300 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @date 2021/3/6-15:52
 */
public class Sol300 {
    /**
     * dp TC:O(n^2)   SC:O(n)
     * 状态转移方程  dp[i]=max(dp[j])+1  其中0<=j<i   nums[j]<nums[i]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1) return 1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxLen=1;
        for (int i = 1; i < nums.length; i++) {
            // 每次都初始化为1目的是，最长递增序列可能当前元素开始，
            // 如果nums[i]>nums[j] j<i  再更新dp[i]
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }

    //法二  dp+二分   TC:O(nlogn)   SC:O(n)
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS1(int[] nums) {
        // tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值
        int[] tails = new int[nums.length];
        // tail当前长度，代表直到当前的最长上升子序列长度。
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            // 通过二分法遍历 [0,res) 列表区间，找出 nums[k] 的大小分界点
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
