import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description [22] 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @date 2020/12/29 0029-9:29
 */
public class Sol22 {
    public static void main(String[] args) {
        List<String> res=generateParenthesis(3);
        System.out.println(res);
    }
    public static List<String> generateParenthesis(int n){
        List<String> res=new ArrayList<>();
        backTrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    /**
     *
     * @param res 结果
     * @param cur 结果集中每一个符合条件的子结果
     * @param open 左括号数目
     * @param close 右括号数目
     * @param max  最大长度一半，这里为n
     */
    public static void backTrack(List<String> res,StringBuilder cur,int open,int close,int max){
        if(cur.length()==max*2){
            res.add(cur.toString());
            return;
        }
        //如果左括号数量不大于 n，我们可以放一个左括号。
        if(open<max){
            cur.append('(');
            backTrack(res,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        //如果右括号数量小于左括号的数量，我们可以放一个右括号。
        if(close<open){
            cur.append(')');
            backTrack(res,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    //法二 动态规划
    //题解  https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
    public static List<String> generateParenthesis1(int n){
        LinkedList<LinkedList<String>> res=new LinkedList<>();
        if(n==0) return new ArrayList<>();
        LinkedList<String> list0=new LinkedList<>();
        list0.add("");
        res.add(list0);
        LinkedList<String> list1=new LinkedList<>();
        list1.add("()");
        res.add(list1);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> tmp=new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1=res.get(j);
                List<String> str2=res.get(i-1-j);
                for(String s1:str1){
                    for(String s2:str2){
                        String e1="("+s1+")"+s2;
                        tmp.add(e1);
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(n);
    }
}
