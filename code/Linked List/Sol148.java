/**
 * @Description [148] 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 * @date 2020/11/21-10:13
 */
public class Sol148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //TC:O(nlogn)  SC:O(1)
        //节点个数是偶数时，中间节点分偏左和偏右的，在这个while循环条件，如果初始化fast=head，slow永远会是偏右的那个
        //在递归的过程中拆分到只剩两个节点时，这两个节点永远拆不开，
        //如果要初始化fast=head，while循环条件改成后面那样的即可
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        /**
         * 或
         * ListNode slow=head,fast=head;
         *  while(fast.next.next!=null && fast.next!=null){...}
         */

        ListNode tmp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(tmp);

        //将两个链表按升序拼接
        ListNode dummyHead=new ListNode(0);
        ListNode res=dummyHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                dummyHead.next=left;
                left=left.next;
            }else{
                dummyHead.next=right;
                right=right.next;
            }
            dummyHead=dummyHead.next;
        }
        dummyHead.next=(left!=null?left:right);
        return res.next;
    }
}
