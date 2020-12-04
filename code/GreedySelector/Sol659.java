package GreedySelector;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description [659] 分割数组为连续的子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * @date 2020/12/4 0004-10:18
 */
public class Sol659 {
    //法一 哈希表+最小堆
    //TC：O(nlogn) SC:O(n)
    //官方题解
    public boolean isPossible(int[] nums){
        /**
         * 哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，
         * 最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
         */
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        //遍历数组，当遍历到元素x时，可以得到一个以x结尾的子序列。
        for (int x : nums) {
            if(!map.containsKey(x)){
                map.put(x,new PriorityQueue<Integer>());
            }
            /**
             * 如果哈希表中存在以 x-1结尾的子序列，则取出以x−1 结尾的最小的子序列长度
             * 将子序列长度加 1之后作为以 x结尾的子序列长度。
             * 此时，以x−1结尾的子序列减少了一个，以 x结尾的子序列增加了一个。
             */
            if(map.containsKey(x-1)){
                int preLength=map.get(x-1).poll();
                if(map.get(x-1).isEmpty()){
                    map.remove(x-1);
                }
                map.get(x).offer(preLength+1);
            }
            //如果哈希表中不存在以 x−1 结尾的子序列，则新建一个长度为 1 的以 x 结尾的子序列
            else{
                map.get(x).offer(1);
            }
        }
        /**
         * 由于数组是有序的，因此当遍历到元素 x 时，数组中所有小于 x 的元素都已经被遍历过，
         * 不会出现当前元素比之前的元素小的情况。
         */
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet=map.entrySet();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry:entrySet){
            PriorityQueue<Integer> queue=entry.getValue();
            if(queue.peek()<3){
                return false;
            }
        }
        return true;
    }

    //法二 贪心算法
    //TC：O(n) SC:O(n)
    //官方题解
    public boolean isPossible1(int[] nums){
        //第一个哈希表存储数组中的每个数字的剩余次数
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        //第二个哈希表存储数组中的每个数字作为结尾的子序列的数量
        Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
        for(int x:nums){
            int count = countMap.getOrDefault(x, 0)+1;
            countMap.put(x,count);
        }

        for(int x:nums){
            int count = countMap.getOrDefault(x, 0);
            //只有当一个数字的剩余次数大于 00 时，才需要考虑这个数字是否属于某个子序列。
            if(count>0){
                //根据第二个哈希表判断以x-1结尾的子序列的数量是否大于0
                int preEndCount=endMap.getOrDefault(x-1,0);
                if(preEndCount>0){
                    /**
                     * 如果大于 0，则将元素 x 加入该子序列中。
                     * 由于 x 被使用了一次，因此需要在第一个哈希表中将 x 的剩余次数减 1。
                     * 又由于该子序列的最后一个数字从 x−1 变成了 x，
                     * 因此需要在第二个哈希表中将 x−1 作为结尾的子序列的数量减 1，
                     * 以及将 x 作为结尾的子序列的数量加 1。
                     */
                    countMap.put(x,count-1);
                    endMap.put(x-1,preEndCount-1);
                    endMap.put(x,endMap.getOrDefault(x,0)+1);
                }
                /**
                 * 否则，x 为一个子序列的第一个数，为了得到长度至少为 3 的子序列，x+1 和 x+2 必须在子序列中，
                 * 因此需要判断在第一个哈希表中 x+1 和 x+2 的剩余次数是否都大于 0。
                 */
                else{
                    int count1 = countMap.getOrDefault(x+1, 0);
                    int count2 = countMap.getOrDefault(x+2, 0);
                    //当 x+1x+1 和 x+2x+2 的剩余次数都大于 0 时，可以新建一个长度为 3 的子序列 [x,x+1,x+2]。
                    if(count1>0 && count2>0){
                        //更新第一个哈希表中x,x+1,x+2的剩余次数
                        countMap.put(x,count-1);
                        countMap.put(x+1,count1-1);
                        countMap.put(x+2,count2-1);
                        //在第二个哈希表中将 x+2 作为结尾的子序列的数量加 1。
                        endMap.put(x+2,endMap.getOrDefault(x+2,0)+1);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
