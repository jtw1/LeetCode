package LeetCodeTest;

public class Solu83 {
    public ListNode deleteDuplicates(ListNode head) {
        //法一
        // ListNode p = head;
        // while (p!=null && p.next!=null) {
        //     if (p.val==p.next.val) {
        //         p.next=p.next.next;
        //     } else {
        //         p=p.next;
        //     }
        // }
        // return head;

        //法二
        /**
         * 当指针temp所指当前结点的值与下一节点值不同时，下一个结点保留，指针移位到下一节点。
         * 当指针temp所指当前结点的值与下一节点值相同时，如果直接跳过下一个结点，可能指针指到的结点值还是
         * 相同的，这样就造成错误。如何跳过所有相同值，就需要另外一个指针cursor指到具有相同值的最后一个结点。
         * 让temp指到cursor下一个结点，从而跳过所有重复值。
         * cursor在移动时，只要下一节点存在且值相同则移位。
         * 要使用.next，就必须注意非null的判断。
         */
        if (head==null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val != p.next.val) {
                p=p.next;
            } else {
                ListNode cur = p.next;
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                p.next = cur.next;
            }
        }
        return head;
    }
}