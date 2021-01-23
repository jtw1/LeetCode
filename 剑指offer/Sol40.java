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

    public void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
