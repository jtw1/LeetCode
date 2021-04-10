package Sort;

/**
 * @Description
 * @date 2021/4/8-21:44
 */
public class QuickPaiXu {
    public static void main(String[] args) {
        int[] arr={13,15,24,99,14,11,1,2,3};
        System.out.print("排序前");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        quickSort(arr,0,8);
        System.out.println();
        System.out.print("排序后");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums,int left, int right){
        if (left<right){
            int index=getPartition(nums, left, right);
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }
    /**
     * 返回 nums[left] 排序以后应该在的位置
     * nums[left]左边元素都小于nums[left]，nums[left]右边元素都小大于nums[left]
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int getPartition(int[] nums,int left, int right){
        int pivot=nums[left];
        int j=left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i]<pivot) {
                swap(nums,++j,i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        swap(nums, j, left);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
