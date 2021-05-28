import java.util.PriorityQueue;

/**
 * @Description 215 数组中的第K个最大元素(数组排序后的第k个最大的元素，不是第k个不同的元素)
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @date 2021/3/1 0001-14:49
 */
public class Sol215 {
    public int findKthLargest1(int[] nums, int k) {
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

    // 法二 快排  TC：O(n)  SC:O(1)
    public int findKthLargest(int[] nums, int k){
        int len=nums.length;
        int left=0,right=len-1;
        int target=len-k;

        while (true){
            int index=partition(nums,left,right);
            if(index==target){
                return nums[index];
            }else if(index<target){
                left=index+1;
            }else{
                right=index-1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，
     * 返回 nums[left] 排序以后应该在的位置
     * nums[left]左边元素都小于nums[left]，nums[left]右边元素都小大于nums[left]
     * 在遍历过程中保持循环不变量的语义
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left,int right){
        int pivot=nums[left];
        int j=left;
        for (int i = left+1; i <= right; i++) {
            if(nums[i]<pivot){
                /**
                 * 小于 pivot 的元素都被交换到前面,注意这里没有换到pivot前面
                 * 假如这里碰到数组的第二个元素就小于pivot时，++j和i相等，执行swap之后相当于啥也没干，
                 * 再继续往后遍历，实际上这也是符合最终目的  小于 pivot 的元素都在前面，大于 pivot 的元素都在后面
                 * example：nums:3 5 2 1 6 4,left=0,j=0,i=1
                 * 1: j=0,i=1   nums[i]>pivot,不执行swap  nums:3 5 2 1 6 4,    j=0,i=2
                 * 2: j=0,i=2   nums[i]<pivot,  执行swap  nums:3 2 5 1 6 4,    j=1,i=3
                 * 3: j=1,i=3   nums[i]<pivot,  执行swap  nums:3 2 1 5 6 4,    j=2,i=4
                 * 4: j=2,i=4   nums[i]>pivot,不执行swap  nums:3 2 1 5 6 4,    j=2,i=5
                 * 5: j=2,i=5   nums[i]>pivot,不执行swap  nums:3 2 1 5 6 4,    j=2,i=6，跳出for循环
                 * 最后执行swap(nums,j,left)              nums:1 2 3(pivot) 5 6 4, 达到目的
                 */
                swap(nums,++j,i);
            }
        }
        // 在之前遍历的过程中，满足第一部分 [left + 1, j] < pivot，并且 第二部分 (j, i] >= pivot
        swap(nums,j,left);
        // 将第一部分最后一个数和pivot交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    // partition的另一种写法
    private int partition1(int[] nums,int left,int right){
        // randSwap(nums);
        int pivot=nums[left];
        int i=left+1,j=right;
        while(true){
            // 下标判断放前面，放后面的话  先对 nums[i]<=pivot 判断 可能会出现数组越界
            // nums[i]<=pivot   nums[j]>=pivot  需要将等于的情况加入进去（当数组所有元素都相等时，以nums[left]作为哨兵元素，如果前两个判断条件没加等号，i，j都不变，造成死循环）
            while(i<right && nums[i]<=pivot) i++;
            while(j>left && nums[j]>=pivot) j--;

            if(i>=j) break;
            swap(nums,i,j);



        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
