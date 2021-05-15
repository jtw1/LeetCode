import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 224 基本计算器  包含 + — ( )
 * https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
 * @date 2021/5/15-14:30
 * 题解 https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
 */
public class Sol224 {
    public int calculate(String s){
        /**
         * 利用栈存储当前符号位
         * 符号初始化为1  栈存储的初始值为1
         * 先跳过头部空格
         * 在得到栈 stack 之后， sign 的取值就能够确定了：如果当前遇到了 + 号，则更新 sign←stack.top()
         * 如果当前遇到了 - 号，则更新 sign← -stack.top()
         * 每当遇到 ( 时，都要将当前的 sign 取值压入栈中；因为（ 后面的内容都和这个sign有关
         * 每当遇到 ） 时，都从栈中弹出一个元素 ，因为括号内的部分已计入最后结果中，与这个括号相关的sign没有用了
         */
        Deque<Integer> stack=new LinkedList<>();
        stack.add(1);
        int sign=1;

        int len=s.length();
        int ret=0;
        int i=0;
        while (i<len){
            char c=s.charAt(i);
            if (c==' '){
                i++;
            }else if (c=='+'){
                sign=stack.peek();
                i++;
            }else if (c=='-'){
                sign=-stack.peek();
                i++;
            }else if(c=='('){
                stack.push(sign);
                i++;
            }else if(c==')'){
                stack.pop();
                i++;
            }else{
                long num=0;
                while (i<len && Character.isDigit(c=s.charAt(i))){
                    num=num*10+c-'0';
                    i++;
                }
                ret+=sign*num;
            }
        }
        return ret;
    }
}
