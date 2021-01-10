
/**
 * @Description 18 删除链表中指定节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @date 2021/1/10-10:44
 */
public class Sol18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val) return head.next;
        ListNode pre=head,cur=head.next;
        while(cur!=null && cur.val!=val){
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null) pre.next=cur.next;
        return head;
    }
}
