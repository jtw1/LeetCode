package qianzhuihe;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 930. 和相同的二元子数组 和560类似
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * @date 2021/3/21-11:32
 */
public class Sol930 {
    // 前缀和  TC:O(n)  SC:O(n)
    public int numSubarraysWithSum1(int[] A, int S) {
        if(A==null || A.length==0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0,preSum=0;
        for(int num:A){
            preSum+=num;
            if(map.containsKey(preSum-S)){
                count += map.get(preSum-S);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

    // 三指针  TC:O(n)  SC:O(1)

    /**
     * 我们遍历区间的右端点 j，同时维护四个变量：
     *
     * sum_lo：A[i_lo..j] 的值；
     * sum_hi：A[i_hi..j] 的值；
     * i_lo：最小的满足 sum_lo <= S 的 i；
     * i_hi：最大的满足 sum_hi <= S 的 i。
     * https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/he-xiang-tong-de-er-yuan-zi-shu-zu-by-leetcode/
     */
    public int numSubarraysWithSum(int[] A, int S){
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; j++) {
            sumLo += A[j];
            // While sumLo is too big, iLo++
            while (iLo<j && sumLo>S){
                sumLo -= A[iLo++];
            }

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (iHi<j && (sumHi>S || (sumHi == S && A[iHi] == 0))){
                sumHi -= A[iHi++];
            }
            if (sumLo==S){
                ans += iHi-iLo+1;
            }
        }
        return ans;
    }
}
