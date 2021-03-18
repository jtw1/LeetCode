package qianzhuihe;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 560 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @date 2021/3/18 0018-9:56
 */
public class Sol560 {
    // 前缀和  TC:O(n)  SC:O(n)
    public int subarraySum(int[] nums, int k){
        int len=nums.length;
        //count为结果数目，
        // pre为前缀和（pre[i]代表数组中第一个元素到当前遍历的元素nums[i]之和),由于每个pre只和前一个pre有关，所以只需要一个pre变量，每次更新即可
        // pre[i]=pre[i-1]+nums[i]
        int count=0,pre=0;
        // key-value:前缀和-对应前缀和的数目
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);  //初始情况下，默认前缀和为0的有一个，即空序列，（下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个）
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            // 当前前缀和是pre，如果map中含有键值pre-k，pre-(pre-k)=k,说明存在和为k的连续序列
            if (map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
