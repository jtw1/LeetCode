package LeetCodeTest;
//[21] 合并两个有序链表
//https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
public class MergeList {
    //递归法
    //时间复杂度O(n+m),空间复杂度O(n+m)，两个链表长度分别为n,m
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;         //l1指向链表头节点
        else if(l2==null)    return l1;
        else if (l1.val<l2.val) {          //比较l1,l2的当前值
            l1.next=mergeTwoLists1(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }

    //迭代法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead=new ListNode(-1);
        ListNode prev=prehead;   //创建虚拟节点，位于返回的列表的前一位

        while(l1!=null && l2!=null){
            if (l1.val<l2.val) {
                prev.next=l1;  //将l1当前节点接在prev后面
                l1=l1.next;    //l1指针后移一位
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;    //prev指针后移一位
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next=l1==null? l2:l1; 

        return prehead.next;
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
