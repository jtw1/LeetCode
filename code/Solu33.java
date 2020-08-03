package LeetcodeTest;
// 33 搜索旋转排序数组
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class Solu33 {
    //列真值表   https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }
        return left == right && nums[left] == target ? left : -1;
    }
}