// package LeetCodeTest;

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Stack;


// // [145] 二叉树的后序遍历
// // https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/

// //递归
// public class Solu145 {
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if(root==null) return new ArrayList<>();
//         postorderTraversal(root.left);
//         postorderTraversal(root.right);
//         list.add(root.val);
//         return list;
//     }
// }

// //迭代1
// //前序遍历：根-左-右，每次向链表中添加元素都是加在队尾，遍历从左子树-右子树
// //如果改为向队头添加元素，则前序遍历变成：右-左-根
// //如果在此基础上遍历顺序从右子树-左子树，则前序遍历变成：左-右-根，正好是后序遍历
// class Solu1 {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         Stack<TreeNode> nStack = new Stack<>();
//         LinkedList<Integer> list = new LinkedList<>();
        
//         while(!(nStack.isEmpty()) || root != null){
//             while (root!=null) {
//                 list.addFirst(root.val);
//                 nStack.push(root);
//                 root=root.right;
//             }
//             if (!nStack.isEmpty()) {
//                root = nStack.pop();
//                root = root.left; 
//             }
//         }
//         return list;
//     }
// }


// //迭代
// class Solu2 {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         LinkedList<TreeNode> stack = new LinkedList<>();
//         LinkedList<Integer> output = new LinkedList<>();
//         if (root == null) {
//            return output;
//         }

//         stack.add(root);
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pollLast();
//             output.addFirst(node.val);  //入栈
//             if (node.left != null) {
//                 stack.add(node.left);
//             }
//             if (node.right != null) {
//                 stack.add(node.right);
//             }
//         }
//         return output;
//     }
// }