package LeetcodeTest;

public class Solu486 {
    public boolean PredictTheWinner(int[] nums) {
        // TC:O(n^2)  SC:O(n^2)
        int length = nums.length;
        // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                /**
                 * 玩家a，b，dp[i][j]可以由dp[i + 1][j]，dp[i][j - 1]转化而来，
                 * a在这一轮选了nums[i]时，上一轮肯定是b选择，此时dp[i + 1][j]表示：下标 i+1 到下标 j 时，分数差：b-a
                 *            所以在这一轮a和b的分数之差  nums[i] - dp[i + 1][j]
                 * a在这一轮选了nums[j]时，同理
                 */
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
    // 状态压缩 TC:O(n^2)  SC:O(n)
    // dp[i][j]只和dp[i + 1][j]，dp[i][j - 1]有关系，
    // 即在计算 dp 的第 i 行的值时，只需要使用到 dp 的第 i 行和第 i+1 行的值
    public boolean PredictTheWinner1(int[] nums){
        int len = nums.length;
        if (len<=1) return true;
        int[] dp=new int[len];
        for (int i = 0; i < len; i++) {
            dp[i]=nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++){
                dp[j]=Math.max(nums[i]-dp[j],nums[j]-dp[j-1]);
            }
        }
        return dp[len-1]>=0;
    }
}