package LeetCodeTest;

//import java.util.HashMap;

// [136] 只出现一次的数字
// https://leetcode-cn.com/problems/single-number/description/
public class Solu136 {
    public int singleNumber(int[] nums) {
        //异或运算，将·数组所有元素异或，相同元素异或为零，所以最后得到的结果即为只出现一次的数字
        //时间复杂度O(n)   空间复杂度O(1)
        int single=0;
        for (int num : nums) {
            single ^= num;
        }
        return single;

        //Hashmap
        //时间复杂度O(n)   空间复杂度O(n)
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for (int i : nums) {
        //     Integer count = map.get(i);
        //     //初始的count都是null，每添加一次数据，count设为1，只有再次碰到相同的数时，count设为2
        //     count=(count==null?1:++count);
        //     map.put(i, count);
        // }

        // for (Integer i : map.keySet()) {
        //     Integer count=map.get(i);
        //     if (count==1) {
        //        return i; 
        //     }
        // }
        // return -1;
    }
}