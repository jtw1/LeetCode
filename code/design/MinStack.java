package design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description [155] 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * @date 2021/1/4 0004-9:25
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack=new LinkedList<>();
        minStack=new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(x,minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
        //xStack每次压栈x时，都有与之对应的x作为队列头时，整个队列的最小值，所以xStack每次出栈时，minStack也要出栈
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
