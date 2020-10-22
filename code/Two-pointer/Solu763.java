// 763 划分字母区间
// https://leetcode-cn.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len=S.length();
        for(int i=0;i<len;i++){
            last[S.charAt(i)-'a']=i;  //记录每个字母最后一次出现的下标位置
        }

        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        //当访问到下标end 时，当前片段访问结束，当前片段的下标范围是[start,end]，长度为end−start+1，
        //将当前片段的长度添加到返回值，然后令start=end+1，继续寻找下一个片段。
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
