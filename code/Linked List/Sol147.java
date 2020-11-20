/**
 * @Description [147] 对插入链表进行排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @date 2020/11/20 0020-9:53
 */
public class Sol147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        //TC:O(n^2)   SC:O(1)
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        //维护lastSorted为链表的已排序部分的最后一个节点
        //维护curr为待插入的元素，初始时 curr = head.next。
        ListNode lastSorted=head,curr=head.next;
        while(curr!=null){
            //若 lastSorted.val <= curr.val，说明 curr 应该位于 lastSorted 之后，
            // 将 lastSorted 后移一位，curr 变成新的 lastSorted。
            if(lastSorted.val<=curr.val){
                lastSorted=lastSorted.next;
            }
            //否则，从链表的头节点开始往后遍历链表中的节点，寻找插入curr的位置。
            else{
                ListNode prev=dummyHead;
                while(prev.next.val<=curr.val){
                    prev=prev.next;
                }
                //令prev为插入curr的位置的前一个节点，进行如下操作，完成对curr的插入：
                lastSorted.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
            }
            //令 curr = lastSorted.next，此时curr为下一个待插入的元素。
            curr=lastSorted.next;
        }
        return dummyHead.next;
    }
}
