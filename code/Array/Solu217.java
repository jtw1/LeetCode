package LeetCodeTest;

//import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// [217] 存在重复元素
// https://leetcode-cn.com/problems/contains-duplicate/description/
public class Solu217 {
    public boolean containsDuplicate(int[] nums) {
        //TC:O(n)  SC:O(n)
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!(set.add(i))) {
                return true;
            }
        }
        return false;

        //堆排序
        //TC:O(nlogn)  SC:O(1)
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length-1; i++) {
        //     if (nums[i]==nums[i+1]) {
        //         return true;
        //     }
        // }
        // return false;
    }
}