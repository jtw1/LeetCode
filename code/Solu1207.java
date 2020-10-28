// [1207] 独一无二的出现次数
// https://leetcode-cn.com/problems/unique-number-of-occurrences/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //TC:O(n)  SC:O(n)
        Map<Integer,Integer> occur=new HashMap<>();
        for(int x:arr){
            occur.put(x,occur.getOrDefault(x,0)+1);
        }
        Set<Integer> times=new HashSet<>();
        for(Map.Entry<Integer,Integer> x:occur.entrySet()){
            times.add(x.getValue());
        }
        return times.size()==occur.size();
    }
}
