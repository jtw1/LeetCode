import java.util.Stack;

/**
 * @Description 面试题16.26 计算器    力扣227相同
 * @date 2021/5/15-12:02
 */
public class Calculator {
    public int calculate(String s){
        /**
         * 记录每个数字前面的符号，如果是乘除法就直接和前面的数字运算，再将结果压栈
         * 如果是加减法，直接将数字压栈
         */
        char preSign='+';
        Stack<Integer> stack=new Stack<>();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            //过滤头部空格
            if(c==' ') continue;

            //如果是数字
            if(c>='0' && c<='9'){
                int num=0;
                //找到连续的数字字符串，把它转化为整数
                while (i<len && ((c=s.charAt(i))>='0' && c<='9')){
                    num=num*10+c-'0';
                    i++;
                }
                //这个是为了抵消上面for循环中的i++
                i--;
                //乘法和除法，运算之后在存放到栈中。加法和减法直接存放到栈中
                if (preSign=='*'){
                    stack.push(num*stack.pop());
                }else if (preSign=='/'){
                    stack.push(stack.pop()/num);
                }else if (preSign=='+'){
                    stack.push(num);
                }else if (preSign=='-'){
                    stack.push(-num);
                }
            }else{ //记录前一个的符号
                preSign=c;
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
