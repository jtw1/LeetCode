/**
 * @Description [316] 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 官方题解
 * @date 2020/12/20-10:24
 */
public class Sol316 {
    public String removeDuplicateLetters(String s) {
        if(s==null || s.length()==0) return "";
        int[] nums=new int[26];
        //记录字符是否存在栈sb中  false 不存在
        boolean[] vis=new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(!vis[ch-'a']){
                while(sb.length()>0 && sb.charAt(sb.length()-1)>ch){
                    if(nums[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }
                vis[ch-'a']=true;
                sb.append(ch);
            }
            nums[ch-'a']--;
        }
        return sb.toString();
    }
}
