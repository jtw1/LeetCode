package LeetcodeTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// [347]前k个高频元素
// https://leetcode-cn.com/problems/top-k-frequent-elements/
public class Solu347 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k=2;
        int[] res = topKFrequent(nums, k);
        System.out.print("前k个高频元素：");
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        //pq添加元素时，按默认从小到大的顺序添加元素，所以不能只进行第一个if判断，必须要对map.keySet()所有元素遍历再判断
        for(Integer key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.remove();
        }
        return res;
    }
}
