import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 59-I 滑动窗口最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 题解 https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
 * @date 2021/2/12-15:33
 */
public class Sol59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res=new int[nums.length-k+1];

        /**
         * 队列按从大到小放入（队首最大，队尾最小）
         * 如果首位值（即最大值）不在窗口区间，删除首位
         * 如果新增的值小于队列尾部值，加到队列尾部
         * 如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中 （因为要找的是当前窗口最大值，对于小于当前元素的窗口中的值，已经没有存在的意义，所以删除）
         * 如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小(头到尾)
         */
        //未形成窗口
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到队列中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
        res[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            // i-k表示上一个窗口的第一个元素，在当前区间没有，判断max值时，需要先删除
            if(deque.peekFirst()==nums[i-k]) deque.removeFirst();
            //删除队列中比当前值小的值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }
}
