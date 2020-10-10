// 环形链表
// https://leetcode-cn.com/problems/linked-list-cycle-ii/
//题解 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
//     https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        //法一 哈希表法
        // TC:O(n)   SC:O(n)
        Set<ListNode> map = new HashSet<>();
        while(head!=null){
            if(!map.contains(head)){
                map.add(head);
            }else{
                return head;
            }
            head=head.next;
        }
        return null;

        //法二  双指针法
        // TC:O(n)   SC:O(1)
        ListNode slow=head,fast=head;

        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;
            }

            if(slow==fast){
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
