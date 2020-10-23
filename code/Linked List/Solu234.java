package LeetCodeTest;

// import java.util.ArrayList;
// import java.util.List;

public class Solu234 {
    
    public boolean isPalindrome(ListNode head) {
        //法一，转化成链表，前后双指针遍历
        //时复：O(n)       空复：O(n)
        // List<Integer> vals = new ArrayList<>();
        // ListNode curreNode = head;
        // if (curreNode != null) {
        //    vals.add(curreNode.val);
        //    curreNode = curreNode.next; 
        // }

        // int front = 0;
        // int back = vals.size()-1;       
        // while (front<back) {
        //    //现在比较的是对象Integer是否相等，所以用equals方法
        //    if (!(vals.get(front).equals(vals.get(back)))) {
        //        return false;
        //    }
        //    front++;
        //    back--;
        // }
        // return true;

        //法二：快慢指针同时进行，并将前一半翻转，与后半部分比较
        //时复：O(n)       空复：O(1)
        if (head==null || head.next==null) {
            return true;
        }

        ListNode slow=head,fast=head; //快慢指针
        ListNode pre =head,prepare=null;

        //慢指针每次移动一下，快指针每次移动两下，保障了快指针遍历完时，满指针到一半
        //同时将前半部分翻转
        while (fast!=null && fast.next!=null) {
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
            //取出第一个节点
            pre.next=prepare;
            prepare=pre;
        }

        //上面的while循环遍历完，fast两种情况
        //一：链表长度n为奇数，此时fast不为null，slow指向（（n-1）/2，从零开始的，正好是独立出来的那个节点，为了方便比较，需要移动slow指针到后半部分的起始位置）
        //二：链表长度n为偶数，此时fast为null，slow正好指向后半部分的起始位置，所以不用移动
        if (fast!=null) {
            slow=slow.next;
        }

        //pre指向前半部分翻转后的起始位置，slow指向后半部分的起始位置
        while (pre!=null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre=pre.next;
            slow=slow.next;
        }
        return true;
        
        /*法二.1
        public boolean isPalindrome(ListNode head) {
            if(head==null || head.next==null) return true;
            ListNode middle=middleNode(head);
            ListNode right=reverse(middle.next);
            middle.next=null;
            while(right!=null){
                if(head.val!=right.val){
                    return false;
                }
                head=head.next;
                right=right.next;
            }
            return true;
        }
        //找到中间节点
        public ListNode middleNode(ListNode head){
            ListNode slow=head;
            ListNode fast=head;
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        //翻转链表
        public ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode cur=head;
            while(cur!=null){
                ListNode dummy=cur.next;
                cur.next=pre;
                pre=cur;
                cur=dummy;
            }
            return pre;
        }*/
    }
}
