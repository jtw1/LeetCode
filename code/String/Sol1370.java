/**
 * @Description [1370] 上升下降字符串
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 * @date 2020/11/25 0025-9:31
 */
public class Sol1370 {
    public String sortString(String s) {
        /**
         * 因此我们可以直接创建一个大小为 26 的桶，记录每种字符的数量。每次提取最长的上升或下降字符串时，我们直接顺序或逆序遍历这个桶。
         * 具体地，在遍历桶的过程中，如果当前桶的计数值不为零，那么将当前桶对应的字符加入到答案中，并将当前桶的计数值减一即可。
         * 我们重复这一过程，直到答案字符串的长度与传入的字符串的长度相等。
         * TC:O(26*len(s))   SC:O(26)
         */
        if(s==null || s.length()==0) return s;
        int[] nums=new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        StringBuffer res=new StringBuffer();
        while(res.length()<s.length()){
            for (int i = 0; i < 26; i++) {
                if(nums[i]>0){
                    res.append((char)(i+'a'));
                    nums[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if(nums[i]>0){
                    res.append((char)(i+'a'));
                    nums[i]--;
                }
            }
        }
        return res.toString();
    }
}
