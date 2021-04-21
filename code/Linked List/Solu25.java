import java.util.List;

/**
 * @Description 25 k个一组翻转链表
 * @date 2021/4/21 0021-11:28
 */
public class Solu25 {
    //迭代  TC:O(n) SC:O(1)
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode pre=hair;

        while (head!=null){
            ListNode tail=pre;
            for (int i = 0; i < k; i++) {
                tail=tail.next;
                if (tail==null){
                    //若个数小于k，则不翻转
                    return hair.next;
                }
            }
            ListNode nex=tail.next;
            ListNode[] reverse=myReverse(head,tail);
            head=reverse[0];
            tail=reverse[1];

            // 把子链表重新接回原链表
            pre.next=head;
            tail.next=nex;
            //pre更新为已翻转的前一段的尾结点，head更新为前一段的尾结点的下一结点
            pre=tail;
            head=tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }



    //递归 TC:O(n) SC:O(logn)
    public ListNode reverseKGroup1(ListNode head, int k){
        if (head==null || head.next==null){
            return head;
        }
        ListNode tail=head;
        for (int i = 0; i < k; i++) {
            if (tail==null){
                //若个数小于k，则不翻转
                return head;
            }
            tail=tail.next;
        }
        //翻转前k个元素
        ListNode newHead=reverse(head,tail);
        //下一轮开始的地方就是tail
        head.next=reverseKGroup(tail,k);

        return newHead;
    }

    /**
     * 左闭右开，翻转[head,tail)部分链表
     * @param head 头
     * @param tail 尾
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail){
        ListNode pre=null;
        while (head!=tail){
            ListNode next=head.next;
            head.next=pre;

            pre=head;
            head=next;
        }
        return pre;
    }
}
