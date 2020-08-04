package LeetCodeTest;

public class Solu92 {
    ListNode succNode = null;  //head的后驱节点
    //翻转以head为起点的n个节点，并返回头节点
    public ListNode reverseN(ListNode head, int n) {
        if (n==1) {
           succNode=head.next;
           return head; 
        }
        //以head.next为起点，需要翻转n-1个节点
        ListNode last = reverseN(head.next, n-1);
        head.next.next=head;
        head.next=succNode;  //让翻转之后的head节点和后面的节点连接起来
        return last;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //m=1时，相当于翻转以head为起点的n个节点
        if (m==1) {
            return reverseN(head, n);
        }
        head.next=reverseBetween(head.next, m-1, n-1);//head向右移动了，但是相应的翻转区间不动，所以整体上相当于左移了，所以区间端点每次减一
        return head;
    }
}