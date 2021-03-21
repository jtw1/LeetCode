package qianzhuihe;

import java.util.HashMap;

/**
 * @Description 523 连续的子数组和
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * @date 2021/3/21-15:14
 */
public class Sol523 {
    // 前缀和+哈希(优化空间)   TC:O(n) SC:O(min(len(nums),k))
    public boolean checkSubarraySum(int[] nums, int k){
        // k-v:前缀和-前缀和对应的下表右边界
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); //初始化map，前缀和为0，对应数组首元素左边一个
        int preSum=0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // 防止k为0的情况
            int key=(k==0? preSum : preSum%k);
            if (map.containsKey(key)){
                if (i-map.get(key) >= 2){
                    return true;
                }
                // 程序运行到这一步表示i-map.get(key) < 2
                // 题目要求至少是长度为2的子数组，为了使子数组尽可能长，
                // 所以只需要保存最小索引，当已经存在时则不用再次存入（跳出本次循环进入下一次循环），不然会更新索引值
                continue;
            }
            map.put(key,i);
        }
        return false;
    }
}
