package LeetCodeTest;
/*[26] 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] num=new int[]{1,3,4,5};
        int len = removeDuplicates(num);
        System.out.println("新数组长度："+len);
        for (int i = 0; i < len; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    //放置两个指针i（慢指针）,j（快指针），只要nums[i]==nums[j]，就增加j以跳过重复元素
    //nums[i]!=nums[j]时，将nums[j]赋值给nums[i+1],此时指针i后移一位
    public static int removeDuplicates(int[] nums){
        if(nums==null||nums.length==0)  return 0;
        int i=0;  
        
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]) {
                nums[++i]=nums[j];
            }else
                continue;
        }
        return i+1;
    }  
}