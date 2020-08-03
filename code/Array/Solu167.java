package LeetCodeTest;
// [167] 两数之和 II - 输入有序数组
// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
public class Solu167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        if(numbers==null || len==0 )  return null;
        int[] sol = new int[2];

        //法一，暴力解法
        //时间复杂度O(n^2)  空间复杂度O(1);
        for (int i = 0; i < len-1; i++) {
            int index1 = i+1;
            for (int j = i+1; j < len; j++) {
                //数组中可能有负数，所以这一步不需要
                // if (numbers[j]>=target) {
                //     return null;
                // }
                if (numbers[j]!=(target-numbers[i])) {
                    continue;
                } else {
                   int index2 = j+1;
                   sol[0] = index1;
                   sol[1] = index2;
                   return sol; 
                }
            }
            continue;
        }
        return null;

        //法二,双指针法
        //时间复杂度O(n)  空间复杂度O(1);
        // int i=0,j=len-1;
        // while (i<j) {
        //     int sum = numbers[i]+numbers[j];
        //     if (sum==target) {
        //         return new int[]{i+1,j+1};
        //     }else if(sum<target){
        //         i++;
        //     }else{
        //         j--;
        //     }
        // }
        // return null;

        //法三：双指针+二分（找到右端点）
    //     for (int a = 0; a < numbers.length; a++) {
    //         int index = binarySearch(numbers, a+1, target-numbers[a]);
    //         if(index != -1) return new int[]{a+1,index+1};
    //     }
    //     return null;
    // }
    // //法三：双指针+二分（找到右端点）
    // public int binarySearch(int[] numbers,int start,int target){
    //     int low=start;
    //     int end = numbers.length-1;
    //     while (low<=end) {
    //         int mid = low+(end-low)>>1;
    //         if(numbers[mid]==target)  return mid;
    //         if(numbers[mid] < target)  low=mid+1;
    //         if(numbers[mid] > target)  end=mid-1;
    //     }
    //     return -1; 
    }
}