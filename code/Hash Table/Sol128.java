import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 128 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @date 2021/3/20-15:31
 */
public class Sol128 {
    // 并查集  TC:O(n)   SC:O(n)
    public int longestConsecutive(int[] nums){
        if (nums==null || nums.length==0) return 0;
        // set(可降重)存储数组中所有出现的数，O(1)查找
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        // 最长连续序列长度
        int longestSerial=0;
        for (int num:numSet){
            // 对于数组中每个较长连续序列，如果起点为num，一定是在numSet不含有num-1时，起点才会是num
            if (!numSet.contains(num-1)){
                int curNum=num;
                int curSerial=1;  // 记录当前序列长度
                // 序列中含有curNum+1时，继续查找curNum+2，当前序列长度+1
                while (numSet.contains(curNum+1)){
                    curNum++;
                    curSerial++;
                }
                // 更新最长序列长度
                longestSerial=Math.max(curSerial,longestSerial);
            }
        }
        return longestSerial;
    }

    // 哈希+dp   TC:O(n)   SC:O(n)
    // 哈希的k-v:nums中的数-该数所在最长连续序列长度
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        for (int num:nums){
            // 如果map中没有当前遍历的数num，则更新
            if (!map.containsKey(num)){
                // 分别记录num左右相邻的两个数所在的最长连续序列的长度
                int left=map.getOrDefault(num-1,0);
                int right=map.getOrDefault(num+1,0);
                // num所在的连续序列的长度，并更新maxLen
                int len=left+right+1;
                maxLen=Math.max(len,maxLen);
                // num所在的连续序列的长度为len，
                // 更新之前，num左边的数num-1所在的连续序列的起点为 num-left
                //           num右边的数num+1所在的连续序列的终点为 num+right
                // 更新之后，该起点和终点所在的最长连续序列长度均为num所在的最长连续序列长度 len
                map.put(num,len);
                map.put(num-left,len);
                map.put(num+right,len);
            }
        }
        return maxLen;
    }
}
