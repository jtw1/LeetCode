/**
 * @Description 51 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @date 2021/4/10-11:57
 */
public class Sol51 {
    public static void main(String[] args) {
        Sol51 sc=new Sol51();
        int[] nums={7,5,6,4};
        System.out.println(sc.reversePairs(nums));
    }
    public int reversePairs(int[] nums){
        int len=nums.length;
        if(len<2) return 0;
        int[] copy=new int[len];
        for (int i = 0; i < len; i++) {
            copy[i]=nums[i];
        }
        int[] tmp=new int[len];
        return reversePairs(copy,0,len-1,tmp);
    }

    /**
     * 递归计算区间 nums[left]~nums[right] 的逆序对数目并且排序   tmp用于复制nums数组，因为题目没有说原数组可以修改
     * @param nums
     * @param left
     * @param right
     * @param tmp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left==right) return 0;

        int mid=left+(right-left)/2;
        int leftPairs=reversePairs(nums,left,mid,tmp);
        int rightPairs=reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid]<=nums[mid+1]){
            return leftPairs+rightPairs;
        }

        int crossPairs=mergeAndCount(nums,left,mid,right,tmp);
        return leftPairs+rightPairs+crossPairs;
    }

    /**
     * nums[left...mid]   nums[mid+1...right]都是有序的
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i]=nums[i];
        }
        // 数组分为两部分 tmp [left,mid]  tmp [mid+1,right]
        int i=left;
        int j=mid+1;
        int count=0;
        for (int k = left; k <= right; k++) {
            // i超出了左半数组范围，将tmp[j]归并回去
            if (i==mid+1){
                nums[k]=tmp[j];
                j++;
            }// j超出了右半数组范围，将tmp[i]归并回去
            else if(j==right+1){
                nums[k]=tmp[i];
                i++;
            }else if(tmp[i]<=tmp[j]){
                nums[k]=tmp[i];
                i++;
            }else{
                nums[k]=tmp[j];
                j++;
                count += (mid-i+1);
            }
        }
        return count;
    }
}
