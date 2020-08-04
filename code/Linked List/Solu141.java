package LeetCodeTest;
//[141] 环形链表
//https://leetcode-cn.com/problems/linked-list-cycle/description/
//import java.util.HashMap;

public class Solu141 {
    public boolean hasCycle(ListNode head) {
        //快慢指针法 TC:O(n+k)即O(n)（k是环的长度，二者速度差为1时）   SC:O(1) 
        if(head==null || head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast) {
            if (fast==null || fast.next==null) {
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
        
        //TC:O(n)   SC:O(n)
        // HashMap<ListNode,Integer> map = new HashMap<>();
        // int pos=0;
        // while (head!=null) {
        //     if (!map.keySet().contains(head)) {
        //         map.put(head, pos++);
        //         head=head.next;
        //     }else{
        //         return true;
        //     }
        // }
        // return false;
    }
}