package qianzhuihe;

import java.util.HashMap;

/**
 * @Description 974. 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * @date 2021/3/22 0022-10:09
 */
public class Sol974 {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int presum = 0;
        int count = 0;
        for(int x:A){
            presum += x;
            //当前 presum 与 K的关系，余数是几，当被除数为负数时取模结果为负数，需要纠正,这里可以和下面的数组的方法结合理解
            // ex:A:[-1,3,9]  K=3     pre:[-1,2,11]   java中被除数为负数时，除数为正数，余数认为负数
            // 如果 key=preSum%K   -1%3=-1  2%3=2,子数组为[3]的情况就会被忽略，所以需要对负数处理
            int key=(presum%K+K)%K;
            if(map.containsKey(key)){
                count += map.get(key);
            }
            //存入哈希表当前key，也就是余数
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return count;
    }

    // 数组实现
    public int subarraysDivByK1(int[] A, int K){
        int[] map = new int[K];
        map[0]=1;
        int len=A.length;
        int preSum=0,count=0;
        for (int i = 0; i < len; i++) {
            preSum += A[i];
            int key=(preSum%K+K)%K;
            //count添加次数，并将当前的map[key]++;
            count += map[key]++;
        }
        return count;
    }
}
