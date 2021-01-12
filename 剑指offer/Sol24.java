/**
 * @Description [24] 翻转链表 p142
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @date 2021/1/12 0012-11:53
 */
public class Sol24 {
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode prepare=null;
        ListNode pNode=head;
        ListNode pPrev=null;
        while(pNode!=null){
            pPrev=pNode;
            pNode=pNode.next;
            pPrev.next=prepare;
            prepare=pPrev;
        }
        return pPrev;
    }
}
