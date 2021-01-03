/**
 * @Description [86] 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * @date 2021/1/3-10:21
 */
public class Sol86 {
    public ListNode partition(ListNode head, int x) {
        ListNode shortX=new ListNode(-1),longX=new ListNode(-1);
        ListNode stmp=shortX,ltmp=longX;

        while(head!=null){
            if(head.val<x){
                stmp.next=head;
                stmp=stmp.next;
            }else{
                ltmp.next=head;
                ltmp=ltmp.next;
            }
            head=head.next;
        }
        if(stmp!=null){
            stmp.next=longX.next;
        }else{
            stmp=longX.next;
        }
        return shortX.next;
    }
}
