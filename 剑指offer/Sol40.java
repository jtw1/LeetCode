import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Description 40 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @date 2021/1/23-17:38
 */
public class Sol40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // TC:O(nlogk) SC:O(k)
        int[] res=new int[k];
        if(k==0) return res;
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(arr[i]<queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int i=0;
        while(!queue.isEmpty()) res[i++]=queue.poll();
        return res;
    }

    //基于快排变形  TC:O(n)  SC:O(logn)
    public int[] getLeastNumbers1(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    /**
     * 在[l,r]范围内，选择较小的k个数，将其放在下标0-k-1 的位置
     * @param arr
     * @param l
     * @param r
     * @param k
     */
    public void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        // 找出arr[r]应该在的位置pos，pos左边及其自己有num个数，左边均小于等于arr[pos]，左边均大于等于arr[pos]
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        // 若k正好等于num，说明当前数组已符合条件
        // 若k<num，在[l,pos-1]范围内递归
        // 若k>num，说明前num个数都在最小的k个数中，只需要在[pos+1,r]范围内找身下的k - num个数
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    /**
     * 基于随机的划分
     * @param nums
     * @param l
     * @param r
     * @return 先在数组中随机选取一个数，返回这个数在排完序之后的nums数组中 应该在的位置
     */
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    /**
     *
     * @param nums
     * @param l 左边界
     * @param r 右边界
     * @return nums[r]在从小到大排完序之后的nums数组中 应该在的位置
     */
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        // i的初始值为l时
        /**
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    swap(nums, i++, j);
                }
            }
            swap(nums, i, r);
            return i ;
         */
        // 把小于pivot的数放到靠前面 for循环结束时，i即pivot应在的位置的前一个
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 交换nums[j]  nums[j]
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
