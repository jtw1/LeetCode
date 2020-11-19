/**
 * @Description [283] 移动0
 * https://leetcode-cn.com/problems/move-zeroes/
 * @date 2020/11/19 0019-9:22
 */
public class Sol283 {
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,2};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    /*
    使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
    右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
    注意到以下性质：
        左指针左边均为非零数；
        右指针左边直到左指针处均为零。
    因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
    TC:O(n)   SC:O(1)
     */
    public static void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
