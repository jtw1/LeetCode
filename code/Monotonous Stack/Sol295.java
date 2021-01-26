import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description 295 数据流的中位数 (与剑指offer41相同)
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * @date 2021/1/26 0026-14:47
 */
public class Sol295 {
    Queue<Integer> max; //小顶堆（堆顶元素最小），存储较大的一半数字
    Queue<Integer> min; //大顶堆（堆顶元素最大），存储较小的一半数字
    /** initialize your data structure here. */
    public Sol295() {
        max=new PriorityQueue<>();
        min=new PriorityQueue<>((x,y)->(y-x));
    }
    // O(logn)
    public void addNum(int num) {
        if(max.size()!=min.size()){
            max.add(num);
            min.add(max.poll());
        }else{
            min.add(num);
            max.add(min.poll());
        }
    }
    // O(1)
    public double findMedian() {
        return max.size()!=min.size()?max.peek():(max.peek()+min.peek())/2.0;
    }
}
