/**
 * @Description 312 戳气球
 * https://leetcode-cn.com/problems/burst-balloons/
 * @date 2021/3/11 0011-11:18
 */
public class Sol312 {
    /**
     * 区间dp  TC:O(n^3)  SC:O(n^2)
     * 我们观察戳气球的操作，发现这会导致两个气球从不相邻变成相邻，使得后续操作难以处理。
     * 于是我们倒过来看这些操作，将全过程看作是每次  添加一个气球。
     * dp[i][j]表示用气球填满开区间 (i,j)能得到的最多的硬币数，i>=(j-1)时，dp[i][j]
     * 为了防止数组下标越界，先对nums数组处理，假设存在nums[-1]和nums[n],均为1，保存在vals数组中
     * i<(j-1)时，枚举开区间(i,j)内全部位置mid
     * 令 mid 为当前区间第一个添加的气球，该操作能得到的硬币数为  val[i]×val[mid]×val[j]。同时我们递归地计算分割出的两区间对 solve(i,j) 的贡献
     * 这三项之和的最大值，即为 solve(i,j) 的值
     */
    public int maxCoins(int[] nums){
        int len=nums.length;
        int[][] dp=new int[len+2][len+2];
        int[] vals=new int[len+2];
        vals[0]=vals[len+1]=1;
        for (int i = 1; i <= len; i++) {
            vals[i]=nums[i-1];
        }
        /**
         * 这里对i从后往前算的原因，根据递推关系计算dp[i][j]依赖dp[i][mid]，dp[mid][j]  i<mid<j
         * 若从上往下算，dp[i][j]依赖的dp[mid][j]根本就还未算出（mid比i大）
         * 若从下往上算，算dp[i][j]时，(i<mid<j),而j是从上往下算的，dp[i][mid]已算出
         *         依赖的dp[mid][j]   mid>i  所以dp[mid][j]在dp[i][j]之前已经算出
         */
        for (int i = len-1; i >=0; i--) {
            for (int j = i+2; j <= len + 1; j++) {
                for (int mid = i+1; mid < j; mid++) {
                    int sum=vals[i]*vals[mid]*vals[j];
                    sum += dp[i][mid]+dp[mid][j];
                    dp[i][j]=Math.max(dp[i][j],sum);
                }
            }
        }
        return dp[0][len+1];
    }
}
