import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 面试题9 用两个栈实现一个队列 P69
 * @date 2020/12/9 0009-10:57
 */
class CQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    /**
     * 队列：FIFO
     * 入队列
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 出队列
     * @return 删除的队列元素
     */
    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp=stack1.pop();
                stack2.push(temp);
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else{
            int head=stack2.pop();
            return head;
        }
    }
}

//public class Sol9 {
//
//}
