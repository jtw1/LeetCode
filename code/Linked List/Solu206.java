package LeetCodeTest;
//[206] 反转链表
//https://leetcode-cn.com/problems/reverse-linked-list/description/
public class Solu206 {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        //法一：遍历法
        //时间复杂度：O(n)   空间复杂度：O(1)
        // ListNode pre=null;
        // ListNode prepare=null;
        // ListNode node=head;
        // while (node != null) {
        //     pre=node;
        //     node=node.next;
        //     pre.next=prepare;
        //     prepare=pre;
        // }
        // return pre;

        //法二：递归法
        //时间复杂度：O(n)   空间复杂度：O(n)
        //假设链表为1-2-3-4-5
        //括号内为一，代表节点1 有f(1)=f(2)+处理节点1
        //f(2)=f(3)+处理节点2   f(3)=f(4)+处理节点3    f(4)=f(5)+处理节点4
        ListNode newhead = reverseList(head.next);   //每次递归时默认head.next后面的部分都是已经反转的，head.next=5时，return 5,接下来执行reverseList(4)
        head.next.next=head;       //将5指向4
        head.next=null;            //4指向null，此时返回的newhead是 5-4-null
        //接下来执行reverseList（3），代码解析为4->next = 3,3->next = null，
        //这个时候p就变成了，5->4->3->null, reverseList(2), reverseList(1)依次类推，p就是:5->4->3->2->1->null

        return newhead;
    }
}