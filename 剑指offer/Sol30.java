import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 30 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @date 2021/1/16-14:49
 */
public class Sol30 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;    //辅助栈 用于存放xStack每添加一个元素时，对应的整个栈中的最小值
    /** initialize your data structure here. */
    public Sol30() {
        xStack=new LinkedList<>();
        minStack=new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
