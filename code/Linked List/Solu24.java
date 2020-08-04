package LeetCodeTest;
// [24] 两两交换链表中的节点
// https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
public class Solu24 {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
        // if(head==null || head.next==null) return null;
        // //需要操作的步骤
        // ListNode next = head.next;
        // head.next = swapPairs(next.next);
        // next.next=head;
        // //返回值
        // return next;

        //迭代法
        ListNode pre = new ListNode(-1);
        pre.next=head;
        ListNode temp=pre;
        //每两个节点交换，如果碰到单独出来的节点，不执行下面的循环体
        while (temp.next!=null && temp.next.next!=null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            //交换
            temp.next=end;
            start.next=end.next;
            end.next=start;
            temp=start;
        }
        return pre.next;
    }
}