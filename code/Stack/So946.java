import java.util.Stack;

/**
 * @Description 946 验证栈序列
 * https://leetcode-cn.com/problems/validate-stack-sequences/
 * @date 2021/1/17-11:10
 */
public class So946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> helper=new Stack<>();
        int index=0;
        for(int num:pushed){
            helper.push(num);
            while(!helper.isEmpty() && helper.peek()==popped[index]){
                helper.pop();
                index++;
            }
        }
        return helper.isEmpty();
    }
}
