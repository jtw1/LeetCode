/**
 * @Description 打家劫舍II
 * @date 2021/5/16-10:40
 */
public class Sol213 {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,len-2),rob(nums,1,len-1));
    }

    public int rob(int[] nums,int begin,int end){
        int pre2=0,pre1=0;
        for(int i=begin;i<=end;i++){
            int cur=Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }
}
