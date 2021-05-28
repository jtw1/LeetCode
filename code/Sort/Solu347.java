package Sort;

import java.util.*;

/**
 * @Description 347 前k个高频元素
 * @date 2021/5/28 0028-9:17
 */
public class Solu347 {
    public int[] topKFrequent(int[] nums, int k){
        if(nums==null || nums.length==0) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 小顶堆，大到小  堆顶最小
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> map.get(o1)-map.get(o2));
        for(Integer key:map.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }else if (map.get(key)>map.get(pq.peek())){
                // pq.remove();
                pq.poll();
                pq.add(key);
            }
        }

        int[] res=new int[k];
        int i=0;
        while (!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        return res;
    }

    // 桶排序    TC:O(n)  SC:O(n)
    public int[] topKFrequent1(int[] nums, int k){
        if(nums==null || nums.length==0) return new int[0];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 桶排序  将频率作为数组下标  对出现频率不同的数字集合，存入对应的数组下标位置
        List<Integer>[] list=new List[nums.length+1];
        for(Integer key:map.keySet()){
            int i=map.get(key);
            if (list[i]==null){
                list[i]=new ArrayList<>();
            }
            list[i].add(key);
        }
        // 存储前k个高频元素
        List<Integer> topK = new ArrayList<>();
        for(int i=list.length-1;i>=0 && topK.size()<k;i--){
            if (list[i]==null) continue;

            // 出现频率为i的元素个数+topK中元素个数 <= k时，直接添加 list[i]中所有元素,否则添加前k-topK.size()个元素
            if (list[i].size()<=(k-topK.size())){
                topK.addAll(list[i]);
            }else{
                // sunList 左闭右开
                topK.addAll(list[i].subList(0,k-topK.size()));
            }
        }

        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=topK.get(i);
        }
        return res;
    }

}
