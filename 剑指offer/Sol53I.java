/**
 * @Description 53-I 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @date 2021/1/31-16:49
 */
public class Sol53I {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=8;
        int res=search(nums,target);
        System.out.println(res);
    }
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int begin=0,end=nums.length-1;
        int count=0;
        while(begin<=end){
            // + 的优先级大于 >>
            int mid=begin+((end-begin)>>1);

//            if(nums[mid]==target){
//                int tmp=mid;
//                while(tmp>=0 && nums[tmp]==target){
//                    tmp--;
//                }
//                while(mid<=nums.length-1 && nums[mid]==target){
//                    mid++;
//                }
//                return mid-tmp-1;
//            }

            if(nums[mid]==target){
                count++;
                int tmp=mid;
                while(mid>0 && nums[--mid]==target) count++;
                while(tmp<nums.length-1 && nums[++tmp]==target) count++;
                break;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                begin=mid+1;
            }
        }
        return count;
    }
}

