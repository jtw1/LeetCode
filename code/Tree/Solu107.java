// package LeetCodeTest;

// // [107] 二叉树的层次遍历 II
// // https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/

// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;
// import java.util.Stack;


// public class Solu107 {
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> res = new LinkedList<>();
//         Queue<TreeNode> nStack = new ArrayDeque<>();
//         if (root!=null) {
//            nStack.add(root); 
//         }

//         while (!nStack.isEmpty()) {
//             int n=nStack.size();
//             List<Integer> level = new ArrayList<>();
//             for (int i = 0; i < n; i++) {
//                 TreeNode node = nStack.poll();
//                 level.add(node.val);
//                 if (node.left!=null) {
//                    nStack.add(node.left);
//                 }
//                 if (node.right!=null) {
//                     nStack.add(node.right);
//                 }
//             }
            
//             res.add(0, level);
//         }
//         return res;
//     }
// }