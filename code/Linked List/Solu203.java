package LeetCodeTest;
// [203] 移除链表元素
// https://leetcode-cn.com/problems/remove-linked-list-elements/description/
public class Solu203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode Firstnode = new ListNode(0);
        Firstnode.next = head;
        ListNode preNode = Firstnode,cur=head;
        while (cur!=null) {
            if (cur.val==val)  preNode.next = cur.next;
            else preNode = cur;
            cur = cur.next;
        }
        return Firstnode.next;
    }
}