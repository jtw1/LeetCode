// package LeetCodeTest;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;


// // [94] 二叉树的中序遍历
// // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
// public class Solu94 {
//     //递归
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null)  return new ArrayList<>();
//         inorderTraversal(root.left);
//         list.add(root.val);
//         inorderTraversal(root.right);
//         return list;
//     }
// }

// //迭代
// class Solu {   
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null)  return new ArrayList<>();
//         Stack<TreeNode> nStack = new Stack<>();
//         List<Integer> list = new ArrayList<>();
//         TreeNode cur = root;

//         while (nStack.size()>0 || cur != null) {
//             while (cur != null) {
//                nStack.push(cur);
//                cur=cur.left;
//             }
//             TreeNode node = nStack.pop();
//             list.add(node.val);
//             if (node.right != null) {
//                 cur=cur.right;
//             }
//         }
//         return list;
//     }
// }