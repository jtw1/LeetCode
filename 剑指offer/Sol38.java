import java.util.HashSet;
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
}
