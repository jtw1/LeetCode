package LeetCodeTest;
//leetcode 27
public class RemoveEqualElement {
    public static void main(String[] args) {
        int[] num=new int[]{1,2,1,3,4,1,1};
        int len = removeElement1(num, 1);
        System.out.println("新数组长度："+len);
        for (int i = 0; i < len; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
    //时间复杂度：O(n)，
    //假设数组总共有 n 个元素，i 和 j 至少遍历 2n 步。
    //空间复杂度：O(1)。
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0 || nums==null)   return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++]=nums[j];
            }else
                 continue;
        }
        return i;
    }
    //时间复杂度：O(n)，i 和 n 最多遍历 n 步。
    //在这个方法中，赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率会更高。
    //空间复杂度：O(1)。

    public static int removeElement1(int[] nums, int val) {
        if(nums.length==0 || nums==null)   return 0;
        int i = 0;
        int n=nums.length;
        while(i<n){
            if (nums[i]==val) {
                nums[i]=nums[n-1];
                nums[n-1]=val;
                n--;  //数组长度减少一,释放最后一个元素
            }else{
                i++;
            }
        }
        return n;
    }

}