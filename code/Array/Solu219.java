package LeetCodeTest;

import java.util.HashSet;
import java.util.Set;

// [219] 存在重复元素 II
// https://leetcode-cn.com/problems/contains-duplicate-ii/description/
public class Solu219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //哈希表
        //维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
        //每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
        //TC:O(n)    SC:O(min(n,k))
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k) {
                set.remove(nums[i-k]);
            }
        }
        return false;


         //TC:O(n^2)    SC:O(1)
        //  for (int i = 0; i < nums.length-1; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i]==nums[j]) {
        //             if((j-i)<k)  return true;
        //         }
        //     }
        // }
        // return false;
    }
}