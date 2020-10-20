// [143] 重排链表
// https://leetcode-cn.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //TC:O(n)  SC:O(1)
        if(head==null) return;
        ListNode mid = middleNode(head);  
        ListNode h=head,p=mid.next;  //将原链表分为两部分，第一部分以head开头，mid结尾，第二部分以mid.next开头
        mid.next=null;  //以mid为分割切断原链表
        p=reverseList(p); 
        mergeList(h,p);
    }
    //寻找链表中间节点
    public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //将链表反向
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nextTemp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextTemp;
        }
        return prev;
    }
    //合并链表
    public void mergeList(ListNode h,ListNode p){
        ListNode h_temp;
        ListNode p_temp;
        while(h!=null && p!=null){
            h_temp=h.next;
            p_temp=p.next;

            h.next=p;
            h=h_temp;

            p.next=h;
            p=p_temp;
        }
    }
}
