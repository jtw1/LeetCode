/**
 * @Description 57 和为s的两个数
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @date 2021/2/10-10:38
 */
public class Sol57 {
    public int[] twoSum(int[] nums, int target) {
        int begin=0,end=nums.length-1;
        while(begin<end){
            int tmp=nums[begin]+nums[end];
            if(tmp==target){
                return new int[]{nums[begin],nums[end]};
            }else if(tmp>target){
                end--;
            }else{
                begin++;
            }
        }
        return new int[0];
    }
}
