import java.util.Arrays;

/**
 * @Description 61 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @date 2021/2/15-15:43
 */
public class Sol61 {
    public boolean isStraight(int[] nums) {
        // 剑指offer思路
        int numberOfZero=0,numberOfGap=0;
        Arrays.sort(nums);
        for(int num:nums){
            if(num==0) numberOfZero++;
        }
        int small=numberOfZero,big=numberOfZero+1;
        while(big<nums.length){
            if(nums[small]==nums[big]) return false;
            numberOfGap += nums[big]-nums[small]-1;

            small=big;
            big++;
        }
        return numberOfGap>numberOfZero? false:true;
    }

    public boolean isStraight1(int[] nums){
        // @Krahets 思路
        // 顺子的充分条件 1.除大小王，所有牌无重复
        //               2.最大牌为max，最小牌min(除大小王) max-min<5
        int numberOfZero=0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if(nums[i]==0) numberOfZero++;
            else if(nums[i]==nums[i+1]) return false;
        }
        return nums[4]-nums[numberOfZero] < 5;
    }
}
