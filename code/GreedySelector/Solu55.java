package GreedySelector;

/**
 * @Description 55 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 * @date 2021/3/7-11:39
 */
public class Solu55 {
    /**
     * 贪心  TC:O(n) SC:O(1)
     * 核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达。
     * 思路：对于每一个可以达到的位置x，它使得x+1,x+2,x+3,...x+nums[x]都可以到达
     * 遍历数组中的每个位置x，实时维护它可以达到的最远的位置 maxDistance,即x+nums[x]
     * 若maxDistance>=数组最后一个位置，说明最后一个位置可达；反之，遍历结束时，最后一个位置仍不可达，false
     */
    public boolean canJump(int[] nums){
        int len=nums.length;
        int maxDistance=0;

        for (int i = 0; i < len; i++) {
            if(i<=maxDistance){
                maxDistance=Math.max(maxDistance,i+nums[i]);
                if(maxDistance>=len-1) return true;
            }
        }
        return false;

        /**
         * 另一种写法
         */
//        for (int i = 0; i < len; i++) {
//            if(i>maxDistance) return false;
//            maxDistance=Math.max(maxDistance,i+nums[i]);
//        }
//        return true;
    }

}
