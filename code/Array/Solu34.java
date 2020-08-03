package LeetCodeTest;
// [34] 在排序数组中查找元素的第一个和最后一个位置
// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class Solu34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1}; 
        if(nums==null || nums.length==0) return res;
        if(nums.length==1) return nums[0]==target? new int[]{0,0}:res;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target) {
                int temp=mid-1;
                while (nums[temp-1]==target&&(temp-1)>=0) {
                    temp--;
                }
                while (nums[mid+1]==target&&(mid+1)<nums.length) {
                    mid++;
                }
                res[0]=temp;
                res[1]=mid;
                return res;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
}