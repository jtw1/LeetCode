import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Description 581 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @date 2021/3/18 0018-10:58
 */
public class Sol581 {
    // 先排序再比较  TC:O(nlogn)  SC:O(n)
    public int findUnsortedSubarray(int[] nums){
        int[] cNums= nums.clone();
        Arrays.sort(cNums);
        int begin=nums.length,end=0;
        for (int i = 0; i < nums.length; i++) {
            if (cNums[i]!=nums[i]){
                begin=Math.min(begin,i);
                end=Math.max(end,i);
            }
        }
        return end-begin>=0?end-begin+1:0;
    }
    // 栈 TC:O(n)  SC:O(n)
    public int findUnsortedSubarray1(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int begin=nums.length,end=0;

        for (int i = 0; i < nums.length; i++) {
            //栈顶元素大于当前元素，出栈，并更新begin
            while (!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                begin=Math.min(begin,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length-1; i >= 0; i--) {
            //栈顶元素小于当前元素，出栈，并更新end
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                end=Math.max(end,stack.pop());
            }
            stack.push(i);
        }
        return end-begin>=0?end-begin+1:0;
    }

    /**
     * 图解 https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/
     * 数组仍旧分为【有序部分1(左段)】+【无序部分(中段)】+【有序部分2(右端)】
     * 从左到右维护一个最大值max,在进入右段之前，那么遍历到的nums[i]都是小于max的，我们要求的end就是遍历中最后一个小于max元素的位置；
     * 同理，从右到左维护一个最小值min，在进入左段之前，那么遍历到的nums[i]也都是大于min的，要求的begin也就是最后一个大于min元素的位置。
     */
    //  TC:O(n)  SC:O(1)
    public int findUnsortedSubarray2(int[] nums){
        int len=nums.length;
        if (len==1) return 0;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < len; i++) {
            //从左到右维持最大值，寻找右边界end
            if (nums[i]<max){
                end=i;
            }else {
                max=nums[i];
            }
            //从右到左维持最小值，寻找左边界begin
            if (nums[len-1-i]>min){
                begin=len-1-i;
            }else {
                min=nums[len-1-i];
            }
        }
        return end-begin>=0?end-begin+1:0;
    }
}
