/**
 * @Description [23] 合并k个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @date 2021/1/3-16:09
 */
public class Sol23 {
    //TC:O(kNlogK)  SC:O(1)    lists中k个链表
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0) return null;
        int len=lists.length;
        // 将n个链表以中间为对称，合并，即合并
        while(len>1){
            for (int i = 0; i < len / 2; i++) {
                lists[i]=mergeTwoLists(lists[i],lists[len-i-1]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }

    //合并两个排序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode p=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        p.next=l1!=null?l1:l2;
//        if(l1!=null){
//            p.next=l1;
//        }else if(l2!=null){
//            p.next=l2;
//        }
        return head.next;
    }
}
