package LeetCodeTest;

// [109] 有序链表转换二叉搜索树
// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/

// public class Solu109 {
//     public TreeNode sortedListToBST(ListNode head) {
//         if(head==null) return null;
//         return BuiTree(head, null);
//     }

//     public TreeNode BuiTree(ListNode head,ListNode end){
//         if(head==end) return null;

//         ListNode fast=head;
//         ListNode slow=head;
//         while (fast!=end && fast.next!=end) {
//             fast=fast.next.next;
//             slow=slow.next;
//         }
//         TreeNode root = new TreeNode(slow.val);
//         root.left=BuiTree(head, slow);
//         root.right = BuiTree(slow.next, end);

//         return root;
//     }

//     //法二：还可以将链表转换成数组，然后类似108题的解法 O(n) O(n)

//     //法三  TC:O(nlogn)  SC:O(n) 
//     //leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-by-/

//     private ListNode FindMidElement(ListNode head){
//         ListNode preNode=null;    //用于隔断链表
//         ListNode slowNode=head;
//         ListNode fastNode=head;

//         while (fastNode!=null && fastNode.next!=null) {
//             preNode=slowNode;
//             slowNode=slowNode.next;
//             fastNode=fastNode.next.next;
//         }

//         if(preNode!=null) preNode.next=null; //preNode正好指向重点，当其不为null时，将链表从中点切断

//         return slowNode;
//     }
//     public TreeNode sortedListToBST(ListNode head) {
//         if(head==null) return null;

//         ListNode mid = FindMidElement(head);
//         TreeNode root = new TreeNode(mid.val);

//         if(head==mid) return root;  //当只有一个元素时，直接返回

//         root.left = sortedListToBST(head);
//         root.right = sortedListToBST(mid.next);

//         return root;
//     }
// }