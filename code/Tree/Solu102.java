// package LeetCodeTest;

// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Queue;

// // [102] 二叉树的层序遍历
// // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
// public class Solu102 {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         //O(n)  O(n)
//         List<List<Integer>> list = new ArrayList<>();  
//         Queue<TreeNode> queue = new ArrayDeque<>();    //同于层次遍历节点的队列
//         if(root!=null) queue.add(root);

//         while (!queue.isEmpty()) {
//             int n= queue.size();  //获取当前队列长度
//             List<Integer> level = new ArrayList<>();  //将每一层的节点存储到一个level中
//             for (int i = 0; i < n; i++) {
//                 TreeNode node = queue.poll();
//                 level.add(node.val);
//                 if (node.left!=null) {
//                     queue.add(node.left);
//                 }
//                 if (node.right!=null) {
//                     queue.add(node.right);
//                 }
//             }
//             list.add(level);
//         }
//         return list;
//     }
// }