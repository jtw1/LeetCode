/**
 * @Description [24] 翻转链表 p142
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @date 2021/1/12 0012-11:53
 */
public class Sol24 {
    /**
     * 迭代  TC:O(n) SC:O(1)
     * 假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3。
     * 即：需要将当前节点的next指针指向前一个节点，由于节点没有引用前一个节点，因此必须先存储其前一个节点
     *    在更改引用之前，还需要存储后一个节点来更新当前节点，最后返回新的头节点
     */
    public ListNode reverseList2(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            // 存储当前节点的后一个节点
            ListNode next=cur.next;
            // 当前节点的next指针指向前一个节点
            cur.next=prev;
            // 当前节点的前一个节点更新为当前节点，然后当前节点更新为他之前的next节点
            prev=cur;
            cur=next;
        }
        return prev;
    }

    // 递归  TC:O(n)  SC::O(n)
    // https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dong-hua-yan-shi-duo-chong-jie-fa-206-fan-zhuan-li/
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;  //防止出现环
        return newHead;
    }


    public ListNode reverseList1(ListNode head){
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
