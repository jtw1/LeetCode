/**
 * @Description [746] 使用最小花费爬楼梯 day
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @date 2020/12/21 0021-9:38
 */
public class Sol746 {
    public int minCostClimbingStairs(int[] cost){
        //dp  TC:O(n)  SC:O(1)
        //假设数组 cost 的长度为 n，则 n 个阶梯分别对应下标 0 到 n-1，楼层顶部对应下标 n，
        // 问题等价于计算达到下标 n 的最小花费。可以通过动态规划求解。
        int len=cost.length;
        int pre=0,curr=0;  //初始状态  pre:到cost[0]最小花费    curr:到cost[1]最小花费
        for (int i = 2; i <= len; i++) {
            int next=Math.min(pre+cost[i-2],curr+cost[i-1]);
            pre=curr;
            curr=next;
        }
        return curr;
    }
}
