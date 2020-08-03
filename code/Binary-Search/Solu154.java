package LeetCodeTest;
// [154] 寻找旋转排序数组中的最小值 II
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
public class Solu154 {
    public int findMin(int[] nums) {
        if(nums.length==0) return nums[0];
        int left=0,right=nums.length-1;
        while (left<right) {
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right]) right=mid;
            else if(nums[mid]>nums[right]) left=mid+1;
            else right -= 1;
        }
        return nums[left];
    }
}