import java.util.Stack;

/**
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @date 2021/3/23 0023-11:36
 */
public class Sol6 {
    // 不用栈  TC：O(n) SC:O(n)  0ms
    public int[] reversePrint(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int[] res=new int[len];
        cur=head;
        for(int i=0;i<len;i++){
            res[len-1-i]=cur.val;
            cur=cur.next;
        }
        return res;
    }

    // 栈  TC：O(2n) SC:O(n)  2ms
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] res=new int[stack.size()];
        int index=0;
        while(!stack.isEmpty()){
            res[index++]=stack.pop();
        }
        return res;
    }


}
