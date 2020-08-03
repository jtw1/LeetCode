package LeetCodeTest;
// [153] 寻找旋转排序数组中的最小值
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
public class Solu153 {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[right]) right=mid;  //mid可能是最小值
            else left=mid+1;  //mid肯定不是最小值
        }
        return nums[left];
    }
}