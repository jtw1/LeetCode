package LeetCodeTest;
// [100] 相同的树
// https://leetcode-cn.com/problems/same-tree/description/
// public class Solu100 {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         //法一 递归
//         //时间复杂度：O(n)    空间复杂度：O(log(n))完全平衡二叉树    O(n)不完全平衡二叉树  
//         if(p==null && q==null)   return true; 
//         if(p==null || q==null)   return false;

//         if (p.val != q.val)      return false;
//         return isSameTree(p.left, q.left) &&
//                isSameTree(p.right, q.right);
//     }
// }