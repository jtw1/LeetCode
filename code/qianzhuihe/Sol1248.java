package qianzhuihe;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 1248. 统计「优美子数组」
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @date 2021/3/22 0022-9:34
 */
public class Sol1248 {
    // 前缀和+hashMap   TC:O(n)  SC:O(n)  54ms
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums.length==0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        //k-v:奇数个数-对应奇数个数的子数组个数
        //这里先put(0,1)的原因是当oddNum正好为k时，count是要加1的，如果不put(0,1)，最终结果会比正确结果少一
        map.put(0,1);
        int count=0,oddNum=0;
        for(int num:nums){
            oddNum += num%2;
            if(map.containsKey(oddNum-k)){
                count += map.get(oddNum-k);
            }
            map.put(oddNum,map.getOrDefault(oddNum,0)+1);
        }
        return count;
    }

    // 前缀和+数组   TC:O(n)  SC:O(n)  3ms
    public int numberOfSubarrays1(int[] nums, int k){
        if (nums.length==0) return 0;
        int[] map=new int[nums.length+1];
        map[0]=1;
        int count=0,oddNum=0;
        for(int num:nums){
            oddNum += (num&1);
            if (oddNum-k >= 0){
                count += map[oddNum-k];
            }
            map[oddNum]++;
        }
        return count;
    }
}
