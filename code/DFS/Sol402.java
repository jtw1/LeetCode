package DFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description [402] 移掉K位数字 每日一题
 * https://leetcode-cn.com/problems/remove-k-digits/
 * 官方题解
 * @date 2020/11/15-10:37
 */
public class Sol402 {
    public String removeKdigits(String num, int k) {
        //贪心+单调栈
        //TC :O(n) SC:O(n)
        Deque<Character> deque = new LinkedList<>();
        int len=num.length();
        /*
        对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，直到
            栈为空
            或者新的栈顶元素不大于当前数字
            或者我们已经删除了k位数字
         */
        for (int i = 0; i < len; i++) {
            char digit=num.charAt(i);
            while(!deque.isEmpty() && k>0 && deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        //如果我们删除了m个数字后此时k（每次移除一个数后k会减一）不为0，这种情况下我们需要从序列尾部删除额外的k个数字。
        //因为在上面的while循环中，k>0时，前两个条件肯定满足，所以deque.peekLast()<digit,
        //所以队尾到队头的数是单调不增的，所以依次删掉队尾的数
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ret=new StringBuilder();
        boolean leadingZero=true;
        //如果最终的数字序列存在前导零，我们要删去前导零。

        while(!deque.isEmpty()){
            char digit=deque.pollFirst();
            if(leadingZero && digit=='0') continue;

            leadingZero=false;
            ret.append(digit);
        }
        //如果最终数字序列为空，我们应该返回 0。
        return ret.length()==0?"0":ret.toString();
    }
}
