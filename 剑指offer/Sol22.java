/**
 * @Description [22] 链表中倒数第k个节点 p134
 *
 * @date 2021/1/12 0012-11:04
 */
public class Sol22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null || k==0) return null;    //链表为空或k为0
        ListNode pAhead=head;
        ListNode pBehind=head;
        for(int i=0;i<k-1;i++){
            //避免k大于链表节点数的情况
            if(pAhead.next!=null){
                pAhead=pAhead.next;
            }else{
                return null;
            }
        }

        while(pAhead.next!=null){
            pAhead=pAhead.next;
            pBehind=pBehind.next;
        }
        return pBehind;
    }
}
