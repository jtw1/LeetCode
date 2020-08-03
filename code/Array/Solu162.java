package LeetCodeTest;
// [162] 寻找峰值
// https://leetcode-cn.com/problems/find-peak-element/description/
public class Solu162 {
    public int findPeakElement(int[] nums) {
        //利用二分法，先找出中间元素nums[mid]，数组不是按升序或降序排列的，是以升序部分和降序部分交替出现的
        //如果nums[mid]<nums[mid-1]，则nums[mid]处在一个降序序列中，峰值在nums[mid]左边
        //如果nums[mid]<nums[mid+1]，则nums[mid]处在一个升序序列中，峰值在nums[mid]右边
        // if(nums==null || nums.length==0) return 0;
        // int begin=0;
        // int end=nums.length-1;
        // while(begin<end){
        //     int mid=begin+(end-begin)>>1;
        //     if(nums[mid]<nums[mid+1]){
        //         begin=mid+1;
        //     }else{
        //         end=mid;
        //     }
        // }
        // return begin;
        return search(nums, 0, nums.length-1);

        
    }
    //递归
    public int search(int[] nums,int l,int r){
         if(l==r) return l;
         int mid = (l+r)/2;
         return (nums[mid]>nums[mid+1]?search(nums, l, mid):search(nums, mid+1, r));  
    }
}