import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description [402] 移掉k位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 * @date 2020/12/23 0023-9:29
 */
public class Sol402 {
    public static void main(String[] args) {
        String num="10200";
        int k=1;
        String res=removeKdigits(num,k);
        System.out.println(res);
    }
    public static String removeKdigits(String num, int k){
        Deque<Character> deque=new LinkedList<>();
        int len=num.length();

        for (int i = 0; i < len; i++) {
            char digit=num.charAt(i);
            //字符串从左往右遍历，栈不为空且  移除的数字的数目小于k   且栈顶元素大于字符串中当前遍历到的数字  移除栈顶元素  将字符串中当前遍历到的数字加入栈中
            while(!deque.isEmpty() && k>0 && deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder res=new StringBuilder();
        boolean leadingZero=true;
        while(!deque.isEmpty()){
            char digit=deque.pollFirst();
            if(leadingZero && digit=='0'){
                continue;
            }
            leadingZero=false;
            res.append(digit);
        }
        return res.length()==0?"0":res.toString();
    }
}
