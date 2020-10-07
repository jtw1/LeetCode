class Solution {
    public void sortColors(int[] nums) {
        //双指针法  TC:O(n)  SC:O(1)
        /*使用指针 p0来交换 0，p2来交换 2。此时，p0的初始值为 0，而 p2的初始值为 n−1。
        在遍历的过程中，我们需要找出所有的 0 交换至数组的头部，并且找出所有的 2 交换至数组的尾部,如果是1，就在中间不用管。
        链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
        */
        if(nums==null || nums.length==0) return;
        int p0=0,p2=nums.length-1;
        //p2是从右向左移动的，从左向右遍历时，位置超过了p2，就可以停止遍历了
        for(int i=0;i<=p2;i++){
            //如果遍历的当前元素为2，将其与nums[p2]交换,p2左移一位
            //nums[i]与nums[p2]交换后，新的nums[i]可能是2，也可能是0，然而此时我们已经结束了交换，开始遍历下一个元素nums[i+1]，不会再考虑nums[i] 了
            //因此，当找到2时，需要不断地将其与nums[p2]交换，直到新的nums[i]不为2，如果是0，就执行接下来的操作，如果是1，不用管
            while(i<=p2 && nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[p2];
                nums[p2]=temp;
                p2--;
            }
            //如果遍历的当前元素为0，将其与nums[p0]交换，p0右移一位
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=temp;
                p0++;
            }
        }
    }
}
