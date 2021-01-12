/**
 * @Description [21] 调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @date 2021/1/12 0012-10:42
 */
public class Sol21 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5};
        exchange(nums);
        for (int tmp : nums) {
            System.out.print(tmp+" ");
        }
    }
    public static int[] exchange(int[] nums) {
        if(nums==null || nums.length==0) return null;
        int begin=0,end=nums.length-1;

        while(begin<end){
            //向右移动begin，直到它指向偶数
            while(begin<end && (nums[begin]&1)!=0) begin++;

            //向左移动end，直到它指向奇数
            while(begin<end && (nums[end]&1)==0) end--;
            if(begin<end) swap(begin,end,nums);
        }
        return nums;
    }

    private static void swap(int a,int b,int[] nums){
        nums[a] =nums[a]^nums[b];
        nums[b] =nums[a]^nums[b];
        nums[a] =nums[a]^nums[b];
    }
}
