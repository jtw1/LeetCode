// package LeetCodeTest;
// // [144] 二叉树的前序遍历

// // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Stack;



// public class Solu144 {
//     //递归法
//     List<Integer> tree = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         //
//         if (root!=null) {
//             tree.add(root.val);
//         }
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//         return tree;
//     }
// }
// //迭代法
// // class Solu{
// //     public List<Integer> preorderTraversal(TreeNode root) {
// //         if(root==null) return return new ArrayList<Integer>();
// //         Stack<TreeNode> nodestack =new Stack<>();
// //         //根节点入栈
// //         nodestack.push(root);
// //         List<Integer> list = new ArrayList<>();

// //         while (!(nodestack.isEmpty())) {
// //             Treenode node = nodestack.pop();
// //             list.add(node.val);
// //             //由于栈的LIFO的特性，前序遍历是“根-左-右”，
// //             //所以先将右节点入栈，再将左节点入栈，出栈的时候就是先左后右了，保证了先序遍历
// //             //时间复杂度O(n)   空间复杂度O(n)
// //             if (node.right != null) {
// //                 nodestack.push(node.right);
// //             }
// //             if (node.left != null) {
// //                 nodestack.push(node.left);
// //             }
// //         }
// //         return list;
// //     }
// // }


// //迭代法2
// class Solu{
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> nStack = new Stack<>();
//         LinkedList<Integer> list = new LinkedList<>();
//         while (!(nStack.isEmpty()) || root !=null) {
//             while (root !=null) {
//                 list.add(root.val);
//                 nStack.push(root);
//                 root=root.left;
//             }
//             if (!nStack.isEmpty()) {
//                 root = nStack.pop();
//                 root=root.right;
//             }
//         }
//         return list;
//     }
// }