package LeetCodeTest;
// [268] 缺失数字
// https://leetcode-cn.com/problems/missing-number/description/
public class Solu268 {
    public int missingNumber(int[] nums) {
        //法一利用高斯公式，TC:O(n) SC:O(1)
        // int max=0;
        // long sum=0;
        // int len = nums.length;
        // for (int i : nums) {
        //     sum += i;
        //     if(i>max) max=i;
        // }
        // long BSum = (1+len)*len/2;
        // return (int) (BSum - sum);

        //法二。位运算 TC:O(n) SC:O(1)
        //思路：将0-n每个数进行异或，再和数组的每个数异或，由于没出现的那个数字，只在0-n中出现了一次，所以最后结果即没出现的那个数字
        //避免了int型数据溢出
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss ^= i^nums[i];
        }
        return miss;
    }
}