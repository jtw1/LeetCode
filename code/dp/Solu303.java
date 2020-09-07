package LeetcodeTest;

public class Solu303 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(2,5);
        System.out.println(param_1);
    }
    
}

class NumArray {
    private int[] sum;
    //使用缓存，速度更快
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
