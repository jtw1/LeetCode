import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description 41 数据流的中位数  p214
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @date 2021/1/26 0026-9:29
 */
public class Sol41 {
    public Queue<Integer> min;  //大顶堆(堆顶元素最大)，存储较小的一半
    public Queue<Integer> max;  //小顶堆(堆顶元素最小)，存储较大的一半
    /** initialize your data structure here. */
    public Sol41() {
        min=new PriorityQueue<>((x,y)->(y-x));
        max=new PriorityQueue<>();
    }
    // O(logn)
    public void addNum(int num) {
        //每插入一个数之前，先判断两个堆的 size() 是否相等
        /**
         * 若不相等，先将这个数插入小顶堆，然后将小顶堆的 poll() 插入大顶堆。
         * 这么做可以保证大顶堆的所有数永远小于等于小顶堆的 poll()。
         */
        if(max.size()!=min.size()){
            max.add(num);
            min.add(max.poll());
        }else{
            /**
             * 若相等，先将这个数插入大顶堆，然后将大顶堆的 poll() 插入小顶堆。
             * 这么做可以保证小顶堆的所有数永远大于等于大顶堆的 poll()。
             */
            min.add(num);
            max.add(min.poll());
        }
    }
    // O(1)
    public double findMedian() {
        /**
         * 若最后两个堆的 size() 不等,说明插入最后一个数之前，两个堆的 size() 相等。
         * 由于当两个堆的 size() 相等时我们总是选择将数插入小顶堆中
         * （先插入大顶堆但马上又将大顶堆的 top() 插入小顶堆），
         * 所以中位数一定是小顶堆的 poll()。
         */
        return max.size()!=min.size()?max.peek():(max.peek()+min.peek())/2.0;
    }
}
