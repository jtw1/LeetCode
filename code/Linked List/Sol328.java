/**
 * @Description 奇偶链表  每日一题
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 官方题解
 * @date 2020/11/13 0013-9:06
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Sol328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        //TC:O(n)    SC:O(1)
        ListNode evenHead=head.next;
        ListNode odd=head,even=evenHead;
        while(even!=null && even.next!=null){
            //更新奇数节点时，奇数节点的后一个节点需要指向偶数节点的后一个节点，然后更新奇数节点为偶数节点后一个节点
            odd.next=even.next;
            odd=odd.next;
            //更新偶数节点时，偶数节点的后一个节点需要指向奇数节点的后一个节点，然后更新偶数节点为奇数节点后一个节点
            even.next=odd.next;
            even=even.next;
        }
        //最后将奇数节点的最后一个节点指向第一个偶数节点
        odd.next=evenHead;
        return head;
    }
}
