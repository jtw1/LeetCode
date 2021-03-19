import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 739 单调栈
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @date 2021/3/19 0019-11:29
 */
public class Sol739 {
    // 单调栈  TC:O(n) SC:O(n)
    public int[] dailyTemperatures(int[] T){
        /**
         * 对于温度列表中的每个元素 T[i]，如果栈为空，则直接将 i 进栈，
         * 如果栈不为空，则比较栈顶元素 prevIndex 对应的温度 T[prevIndex] 和当前温度 T[i]，
         * 如果 T[i] > T[prevIndex]，则将 prevIndex 移除，并将 prevIndex 对应的等待天数赋为 i - prevIndex，
         * 重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈。
         */
        if(T==null || T.length==0) return new int[0];
        int[] res=new int[T.length];
        Deque<Integer> stack=new LinkedList<>();   //存储T中的下标
        for (int i = 0; i < T.length; i++) {
            int temperature=T[i];
            // 弹栈的时候更新res[prevIndex]，因为此时即将进栈的 i 对应的 T[i] 一定是 T[prevIndex] 右边第一个比它大的元素
            while (!stack.isEmpty() && temperature>T[stack.peek()]){
                int prevIndex = stack.pop();
                res[prevIndex]=i-prevIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
