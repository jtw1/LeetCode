/**
 * @Description 23 链表中环的入口节点
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * @date 2021/1/13 0013-10:09
 */
public class Sol23 {
    // slow入环时 fast一定在环内；fast是slow的两倍速度，
    // 故slow走完一环的时候fast肯定也走完了两环，所以必定会在slow走完一环前某个点相遇。
    public ListNode EntryNodeOfLoop(ListNode head){
        //设链表中环外部分的长度为 a，slow 指针进入环后，又走了 b 的距离与 fast 相遇
        // 从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
        // a+n(b+c)+b=2(a+b)==> a=(n-1)(b+c)+c
        if(head==null) return null;
        ListNode fast=head,slow=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }

            if(fast==slow){
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
