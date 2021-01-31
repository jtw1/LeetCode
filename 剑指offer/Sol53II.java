/**
 * @Description 53-II 0~n-1 中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/ * @date 2021/1/31-20:34
 */
public class Sol53II {
    public int missingNumber(int[] nums){
        /**
         * 数组可分为两部分：左子数组：nums[i]=i      右子数组：nums[i]！=i
         * 缺失的数字即右子数组首位元素对应的索引
         */
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]==mid) left=mid+1;
            else right=mid-1;
        }
        // 退出循环时，left即右子数组首位元素对应的索引
        return left;
    }
}
