package LeetCodeTest;
// [98] 验证二叉搜索树
// https://leetcode-cn.com/problems/validate-binary-search-tree/description/
// public class Solu98 {
//     //递归 TC:O(n)  SC:O(n)
//     public boolean isValidBST(TreeNode root) {
//         return isBST(root, null, null);
//     }

//     public boolean isBST(TreeNode root,TreeNode min,TreeNode max){
//         if(root==null) return true;
//         if(min!=null && root.val<=min.val) return false;
//         if(max!=null && root.val>=max.val) return false;

//         return isBST(root.left, min, root) && isBST(root.right, root, max);
//     }

//     //中序遍历 TC:O(n)  SC:O(n)
// }