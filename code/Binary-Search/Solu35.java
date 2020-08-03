package LeetCodeTest;
//搜索插入位置
//https://leetcode-cn.com/problems/search-insert-position/description/
public class Solu35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,7};
        int index = searchInsert(nums, 7);
        System.out.println(index);
    }
    public static int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if (len==0) {
            return 0;
        }
        if (target==nums[len-1]) {
            return len-1;
        }
        if (target>nums[len-1]) {
            return len;
        }
        
        int left = 0;
        int right=len;
        while (left<right) {
            int mid = left+(right-left)/2;
            //int mid = (right+left)>>>1;  
            //无符号右移，即变为原来一半，不论原来是正数还是负数，右移之后最高位都是补0，不用考虑数据溢出的情况
            if (nums[mid]<target) {
                left = mid+1;   //下一轮搜索区间变为[mid+1,right]
            }else if(nums[mid]==target){
                return mid;
            }else{
                right = mid;    //下一轮搜索区间变为[left,mid]
            }
        }
        return left;
    }
}