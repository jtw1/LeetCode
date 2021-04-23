package Sort;

import java.lang.invoke.VarHandle;
import java.util.Random;

/**
 * @Description 921 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 * @date 2021/4/23 0023-11:08
 */
public class Sol921 {
    public int[] sortArray(int[] nums) {
        if(nums.length==1) return nums;
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right){
        if(left<right){
            int index=randomizedPartition(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
    }

    /**
     随机选取一个元素作为哨兵元素，返回该元素应该在的下标,选取随机元素（17ms）作为哨兵元素比直接选取最左或最右边元素(1585ms)要快一些，
     */
    public int randomizedPartition(int[] nums, int left, int right){
        int ele=new Random().nextInt(right-left+1)+left;
        swap(nums,left,ele);
        return partition(nums,left,right);
    }

    private int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int j=left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]<pivot){
                swap(nums,++j,i);
            }
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
