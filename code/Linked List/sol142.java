/**
 * @Description 142 环形链表II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @date 2021/3/28-12:01
 */
public class sol142 {
    // 不能用141题代码搬过来先判断是否有环，再用数学公式求解环的起点，会超出时间限制
    // 因为141中slow,fast起点不一样，于是对应的数学公式就会发生变化，
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }

            if(slow==fast){
                ListNode ptr=head;
                while(ptr!=slow){
                    slow=slow.next;
                    ptr=ptr.next;
                }
                return slow;
            }
        }
        return null;
    }
}
