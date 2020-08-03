package LeetcodeTest;
// 面试题 0803 魔术索引
// https://leetcode-cn.com/problems/magic-index-lcci/
public class Solu0803 {
    public int findMagicIndex(int[] nums) {
        //法一：暴力遍历  TC:O(n)  SC:O(1)
        // int minIndex=-1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==i) {
        //         minIndex=i;
        //         break;
        //     }
        // }
        // return minIndex;

        //二分 TC：O(logn),最坏O(n)  SC:最坏O(n)，取决于递归栈深度  
        return getAnswer(nums, 0, nums.length-1);
        
    }
    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}