package LeetCodeTest;
//import java.util.Arrays;
// [169] 多数元素
// https://leetcode-cn.com/problems/majority-element/description/
import java.util.HashMap;
import java.util.Map;

public class Solu169 {
    //法一。利用hashmap，TC:O(n) SC:O(n)
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        HashMap<Integer,Integer> map = count(nums);
        
        Map.Entry<Integer,Integer> max = null;  //初始化出现次数最多的元素对应的键值对

        for (Map.Entry<Integer,Integer> temp : map.entrySet()) {
            //第一次判断时，max为null，后面就不用看了，增加这个判断条件是为了第一次判断时出现空指针异常
            if (max==null || temp.getValue()>max.getValue()) {
                max=temp;
            }
        }
        return max.getKey();
    }
    //将数组元素和对应的出现次数添加到hashmap中
    private HashMap<Integer,Integer> count(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
        }
        return map;
    }

    //法二：排序，题意是找出数组中出现次数大于length/2的数，不论是升序还是降序排列后，下标为length/2的数即为我们要找的数
    //TC:O(logn) SC:O(logn)(使用语言自带的排序函数)，自己写堆排序只需要O(1)
    // public int majorityElement(int[] nums){
    //     if(nums==null || nums.length==0) return 0;
    //     Arrays.sort(nums);
    //     return nums[nums.length/2];
    // }

    //法三 摩尔投票法  TC:O(n) SC:O(1)
    //先将数组第一个数赋值给一个变量cur，相应value计为1，然后往后遍历，碰到相同数，value+1，不同时，value-1,cur不变
    //value为0时，更新cur为当前nums[i],然后继续遍历，最后cur即为所求，因为要求的数的个数大于剩下所有数的个数，剩下的数计为-1，众数计为1，最后相加肯定大于0
    // public int majorityElement(int[] nums){
    //     if(nums==null || nums.length==0) return 0;
    //     int value=0;
    //     Integer candidate=null;

    //     for (int i : nums) {
    //         if (value==0) {
    //             candidate=i;
    //         }
    //         value += (candidate==i)? 1:-1;
    //     }
    //     return candidate;
    // }

}