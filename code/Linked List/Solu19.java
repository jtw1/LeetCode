package LeetCodeTest;
// [19] 删除链表的倒数第N个节点
// https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
public class Solu19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //法一：一次遍历，双指针 TC:O(L)  SC:O(1)
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = dummy;
        ListNode second = dummy;

        //移动first，使其和second相距n+1(隔了n个节点)
        for (int i = 1; i <= n+1; i++) {
            first=first.next;
        }

        while (first!=null) {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;

        //法二，两次遍历 TC:O(L)  SC:O(1)
        //倒数第n个，即正数L-n+1个
        // ListNode dummy = new ListNode(0);
        // dummy.next=head;
        // ListNode first = head;
        // int len=0;
        // //得到链表长度len
        // while(first!=null){
        //     first=first.next;
        //     len++;
        // }
        // len -= n;
        // first=dummy;
        // while (len>0) {
        //     first=first.next;
        //     len--;
        // }
        // first.next=first.next.next;
        // return dummy.next;
    }
}