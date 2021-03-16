import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 301 删除无效括号
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * @date 2021/3/16 0016-10:31
 */
public class Sol301 {
    private int len;
    private char[] charArr;
    private Set<String> validExpresion=new HashSet<>();

    public List<String> removeInvalidParentheses(String s){
        this.len=s.length();
        this.charArr=s.toCharArray();
        /**
         * 左括号的数目要严格小于右括号的数目，否则表达式无效
         */
        int leftRemove=0,rightRemove=0;
        for (int i = 0; i < s.length(); i++) {
            char c=charArr[i];

            if (c==')'){
                // 当前字符为右括号时，如果需要移除的左括号数目大于0时，当前右括号可以和之前一个左括号配对，所以需要移除的左括号数目减一
                if (leftRemove>0){
                    leftRemove--;
                }
                // 如果需要移除的左括号数目等于0时，需要移除的右括号数目加一
                else if (leftRemove==0){
                    rightRemove++;
                }
            }
            // 当前字符为左括号时，如果需要移除的左括号数目+1
            else if (c=='('){
                leftRemove++;
            }
        }

        StringBuilder path = new StringBuilder();
        dfs(0,0,0,leftRemove,rightRemove,path);
        return new ArrayList<>(this.validExpresion);
    }

    /**
     *
     * @param index 当前遍历的下标
     * @param leftCount 已经遍历到的左括号的个数
     * @param rightCount 已经遍历到的右括号的个数
     * @param leftRemove 需要移除的左括号的个数
     * @param rightRemove 需要移除的右括号的个数
     * @param path 一个可能的结果
     */
    private void dfs(int index,int leftCount,int rightCount,int leftRemove ,int rightRemove,StringBuilder path){
        if (index==len){
            if (leftRemove==0 && rightRemove==0){
                validExpresion.add(path.toString());
            }
            return;
        }
        char tmp=charArr[index];
        // 可能的操作1：删除当前遍历到的字符，
        //     当前遍历的是左括号，且leftRemove大于0时，leftRemove--
        //     由于 rightRemove > 0，并且当前遇到的是右括号，因此可以尝试删除当前遇到的右括号
        if (tmp=='(' && leftRemove>0){
            dfs(index+1,leftCount,rightCount,leftRemove-1,rightRemove,path);
        }else if(tmp==')' && rightRemove>0){
            dfs(index+1,leftCount,rightCount,leftRemove,rightRemove-1,path);
        }

        // 可能的操作2：保留当前字符
        //    如果不是括号，继续深度优先遍历
        //    是左括号/右括号时
        path.append(tmp);
        if (tmp!='(' && tmp!=')'){
            dfs(index+1,leftCount,rightCount,leftRemove,rightRemove,path);
        }else if(tmp=='('){
            dfs(index+1,leftCount+1,rightCount,leftRemove,rightRemove,path);
        }else if(tmp==')' && leftCount>rightCount){
            dfs(index+1,leftCount,rightCount+1,leftRemove,rightRemove,path);
        }
        //回溯
        path.deleteCharAt(path.length()-1);
    }
}
