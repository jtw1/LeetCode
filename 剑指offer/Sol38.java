import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Description 38 字符串排列 p197
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @date 2021/1/25 0025-14:37
 */
public class Sol38 {
    Set<String> res=new HashSet<>();
    public String[] permutation(String s) {
        if(s==null || s.length()==0) return new String[]{""};
        boolean[] visited=new boolean[s.length()];
        process(s,"",visited);
        return res.toArray(new String[res.size()]);
    }

    private void process(String s, String letter, boolean[] visited){
        if(letter.length()==s.length()){
            res.add(letter);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char tmp=s.charAt(i);
            if(visited[i]) continue;
            visited[i]=true;
            //这里的回溯没有删除最后一个元素，因为在Java中string是final的，
            // 给一个string重新赋值，会重新开辟一块空间，
            // 所以letter指向一个地方，letter+tmp指向另一个地方
            process(s,letter+tmp,visited);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        Sol38 sc=new Sol38();
        String[] re=sc.permutation1("abc");
    }

    public String[] permutation1(String s) {
        if(s==null || s.length()==0) return new String[0];
        char[] sArr=s.toCharArray();
        List<String> res=new LinkedList<>();
        dfs(sArr,0,res);
        String[] ans=new String[res.size()];
        // int i=0;
        // for(String str:res){
        //     ans[i++]=str;
        // }
        return res.toArray(new String[res.size()]);
    }

    public void dfs(char[] s, int begin, List<String> res){
        if(begin==s.length-1){
            res.add(String.valueOf(s));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=begin;i<s.length;i++){
            if(set.contains(s[i])) continue;
            set.add(s[i]);
            swap(s,i,begin);
            dfs(s,begin+1,res);
            swap(s,i,begin);
        }
    }

    public void swap(char[] s,int a,int b){
        char tmp=s[a];
        s[a]=s[b];
        s[b]=tmp;
    }
}
