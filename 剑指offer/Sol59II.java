import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 59-2 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @date 2021/1/16-15:00
 */
public class Sol59II {
    Deque<Integer> xStack;
    Deque<Integer> maxStack;
    public Sol59II() {
        xStack=new LinkedList<>();
        maxStack=new LinkedList<>();
    }
    //队列中的最大值
    public int max_value() {
        return maxStack.isEmpty()?-1:maxStack.peek();
    }
    //向队列传入元素
    public void push_back(int value) {
        xStack.offerLast(value);
        while(!maxStack.isEmpty() && maxStack.peekLast()<value){
            maxStack.pollLast();
        }
        maxStack.offerLast(value);
    }
    //删除队列头部元素
    public int pop_front() {
        if(xStack.isEmpty()) return -1;
        int val=xStack.pollFirst();
        if(val==maxStack.peek()){
            maxStack.pollFirst();
        }
        return val;
    }
}
