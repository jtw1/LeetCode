package LeetCodeTest;
// [2] 两数相加
// https://leetcode-cn.com/problems/add-two-numbers/description/
public class Solu2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        //TC:O(max(l1,l2))   SC:O(max(l1,l2))  
        int carry=0,cur=0;
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1,q=l2,temp=dummyHead; 
        while (p!=null || q!=null) {
            //一直判断p，q是否为空，为空时相应位设为0，省去了单独判断 l1或l2的代码
            int x=(p!=null)? p.val:0;
            int y=(q!=null)? q.val:0;
            cur=x+y+carry;
            carry=cur/10;
            temp.next = new ListNode(cur%10);
            temp=temp.next;
            
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        //看最高位是否有进位
        if (carry>0)  temp.next=new ListNode(carry);
        
        return dummyHead.next;
    }
}