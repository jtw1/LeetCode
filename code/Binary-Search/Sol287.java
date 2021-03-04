import java.util.Arrays;

/**
 * @Description 287 寻找重复的数字
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @date 2021/3/4 0004-11:43
 */
public class Sol287 {
    /**
     * 二分法 TC:O(nlogn) SC:O(1)
     * 思路：数组长度为 n+1，数组中数字的范围 [1,n]
     * 中位数为mid，如果整个数组中小于等于mid的数的个数大于mid个，
     * 则重复的数字一定在区间[left，mid]内
     * 反之，不在区间[left，mid]内，更新区间边界为[mid+1,right]
     */
    public int findDuplicate(int[] nums){
        int len = nums.length;
        int left = 1, right = len - 1;
        while (left<right){
            int mid=left+(right-left)/2;

            int cnt=0;
            for (int num:nums) {
                if(num<=mid) cnt++;
            }

            if (cnt>mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    /**
     * 快慢指针  TC:O(n) SC:O(1)
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     * 思路：以数组[1,3,4,2,2]为例，数组下标i和nums[i]存在如下映射
     * 0->1   1->3  2->4  3->2  4->2
     * 同样的，从下标0出发，以nums[i]作为新的下标，可以得到如下链表
     * 0->1->3->2->4->2->4...    其中 2->4 是个循环
     * 然后本题转化成寻找环的入口  与力扣142类似
     */
    public int findDuplicate1(int[] nums){
        int slow=0,fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];

        while (slow!=fast){
            // 相当于 slow=slow.next
            slow=nums[slow];
            // 相当于 fast=fast.next.next;
            fast=nums[nums[fast]];
        }

        int pre1=0;
        int pre2=slow;
        while (pre1!=pre2){
            pre1=nums[pre1];
            pre2=nums[pre2];
        }
        return pre1;
    }

    /**
     * 使用内置函数    TC:O(nlogn) SC:O(logn)
     * 现将数组按从小到大顺序排序  数组长度为 n+1，数组中数字的范围 [1,n]
     * 重复的那个数字第一次出现以后，开始有   nums[i]==i
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i){
                tmp=nums[i];
                break;
            }
        }
        return tmp;
    }
}
