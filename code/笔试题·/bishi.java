package LeetcodeTest;
// 科大讯飞 2021提前批 笔试编程题
public class bishi {
    public int insert(int[] nums,int a){
        return insert(nums, 0, nums.length-1, a);
    }

    public int insert(int[] nums,int left,int right,int a){
        int mid = left+(right-left)/2;
        if(left>right) return -1;
        if(nums[mid]>a) return insert(nums, left, mid-1, a);
        else if(nums[mid]<a) return insert(nums, mid+1, right, a);
        else return mid;
    }
}
