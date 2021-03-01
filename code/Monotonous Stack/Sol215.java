import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 215 数组中的第K个最大元素(数组排序后的第k个最大的元素，不是第k个不同的元素)
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @date 2021/3/1 0001-14:49
 */
public class Sol215 {
    public int findKthLargest(int[] nums, int k) {
        /**
         * 根据k的大小，选最大堆和最小堆
         * k靠近0时，用最大堆，
         * k靠近len时，用最小堆，所以分界点是len/2
         */
        int len=nums.length;
        //使用含有k个元素的最小堆(小到大)
        if(k<=len-k){
            PriorityQueue<Integer> minHeap=new PriorityQueue<>(k,(o1, o2) -> o1-o2);
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < len; i++) {
                // 看一眼，不拿出，因为有可能没有必要替换
                int topEle=minHeap.peek();
                // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                if(nums[i]>topEle){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
            return minHeap.peek();
        }else{
            assert k>len-k;
            int capacity=len-k+1;
            PriorityQueue<Integer> maxHeap=new PriorityQueue<>(capacity,(o1, o2) -> o2-o1);
            for (int i = 0; i < capacity; i++) {
                maxHeap.add(nums[i]);
            }
            for (int i = capacity; i < len; i++) {
                int topEle=maxHeap.peek();
                if(nums[i]<topEle){
                    maxHeap.poll();
                    maxHeap.add(nums[i]);
                }
            }
            return maxHeap.peek();
        }
    }
}
