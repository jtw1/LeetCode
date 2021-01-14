/**
 * @Description 25 合并两个排序链表 p145
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @date 2021/1/14 0014-15:00
 */
public class Sol25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归
        if(l1==null || l2==null) return (l1==null?l2:l1);
        ListNode mergeHead=new ListNode(-1);
        if(l1.val<l2.val){
            mergeHead=l1;
            mergeHead.next=mergeTwoLists(l1.next,l2);
        }else{
            mergeHead=l2;
            mergeHead.next=mergeTwoLists(l1,l2.next);
        }
        return mergeHead;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        //迭代
        if(l1==null || l2==null) return (l1==null?l2:l1);
        ListNode mergeHead=new ListNode(-1),cur=mergeHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next = l1!=null?l1:l2;
        return mergeHead.next;
    }
}
