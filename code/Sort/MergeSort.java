package Sort;

/**
 * @Description 归并排序    TC:O(nlogn)   SC:O(n)
 * @date 2021/4/10-15:38
 * https://blog.csdn.net/qq_36442947/article/details/81612870?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 */
public class MergeSort {

    /**
     * 归并排序 nums[start...end]
     * @param nums
     * @param start
     * @param end
     * @param tmp 辅助数组
     */
    public static void mergeSort(int[] nums,int start,int end,int[] tmp){
        if(start<end){ //子序列只有一个元素时结束递归
            int mid = start+(end-start)/2;
            //对左侧子序列,右侧子序列进行递归排序
            mergeSort(nums,start,mid,tmp);
            mergeSort(nums,mid+1,end,tmp);
            //合并
            merge(nums,start,mid,end,tmp);
        }
    }

    /**
     * 两路归并算法，两个排好序的子序列 [start,mid]  [mid+1,right]合并为一个序列
     * @param nums
     * @param start
     * @param mid
     * @param end
     * @param tmp 辅助数组
     */
    private static void merge(int[] nums, int start, int mid, int end,int[] tmp) {

        int p1=start,p2=mid+1;
        int k=start;    //p1、p2是检测指针，k是存放指针

        while (p1<=mid && p2<=end){
            if(nums[p1]<=nums[p2]){
                tmp[k++]=nums[p1++];
            }else{
                tmp[k++]=nums[p2++];
            }
        }
        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p1<=mid) tmp[k++]=nums[p1++];
        while (p2<=end) tmp[k++]=nums[p2++];

        for (int i = start; i <= end; i++) {
            nums[i]=tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        System.out.print("未排序的数组：");
        for (int e : a)
            System.out.print(e+" ");
        System.out.println();
        int[] tmp=new int[a.length];  //辅助数组
        mergeSort(a, 0, a.length-1,tmp);
        System.out.print("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }
}
