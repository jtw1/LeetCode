package PointToOffer;

/**
 * @Description
 * @date 2020/10/15 0015-21:53
 * 面试题 0302
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3};
        System.out.println("重复的数字是："+getDuplication(nums));
    }

    public static int getDuplication(int[] nums){
        if(nums == null || nums.length <= 0)
            return -1;

        int start = 1;
        int end = nums.length - 1;
        while(end >= start)
        {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, start, middle);
            if(end == start)
            {
                if(count > 1)
                    return start;
                else
                    break;
            }

            if(count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }
    //获取数组中指定范围内的数出现的次数
    public static int countRange(int[] nums,int start,int end){
        if(nums==null || nums.length==0) return 0;
        int count=0;
        for (int num:nums) {
            if(num>=start && num<=end)
                count++;
        }
        return count;
    }
}
