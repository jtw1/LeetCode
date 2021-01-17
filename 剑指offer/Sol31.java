import java.util.List;
import java.util.Stack;

/**
 * @Description 31 栈的压入，弹出
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @date 2021/1/17-10:54
 */
public class Sol31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //TC:O(n) SC:O(n)
        /**
         * 把pushed数组的元素逐个压栈，当栈顶元素等于popped数组中第一个元素的时候，
         * 就让栈顶元素出栈，这个时候再用popped数组的第2个元素和栈顶元素比较，
         * 如果相同继续出栈……，最后判断栈是否为空即可
         */
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek()==popped[i]){
                // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
