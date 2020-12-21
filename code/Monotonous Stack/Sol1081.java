/**
 * @Description [1081] 不同字符的最小子序列
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * @date 2020/12/21 0021-10:09
 */
public class Sol1081 {
    public String smallestSubsequence(String s) {
        //字典序最小  即在字典中的顺序最小   比如：acbd在aebd前面
        int[] nums=new int[26];
        boolean[] vis=new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(!vis[ch-'a']){
                //当栈sb的长度大于0 且栈顶字符大于当前字符ch时
                while(sb.length()>0 && sb.charAt(sb.length()-1)>ch){
                    // 如果栈顶字符（即在字符ch之后依然有栈顶字符，因为前面每次遍历元素，最后都会将遍历到的元素的数量减一）
                    // 就将栈顶字符移除，并将其状态设置为未访问
                    // 如果栈顶字符数量等于0，则不能移除
                    if(nums[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }
                //将ch添加到栈中，并更新其在vis中的状态
                vis[ch-'a']=true;
                sb.append(ch);
            }
            nums[ch-'a']--;
        }
        return sb.toString();
    }
}
