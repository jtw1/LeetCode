package LeetCodeTest;

// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.Queue;


// [226] 翻转二叉树
// https://leetcode-cn.com/problems/invert-binary-tree/description/
// public class Solu226 {
//     public TreeNode invertTree(TreeNode root) {
//         //递归   TC:O(n)  SC:O(n)
//         // if(root==null || (root.left==null && root.right==null)) return root;
        
//         // TreeNode Ltemp = root.left;
//         // TreeNode Rtemp = root.right;
//         // root.left=invertTree(Rtemp);
//         // root.right=invertTree(Ltemp);

//         // return root;

//         //迭代   TC:O(n)  SC:O(n)
//         if(root==null) return root;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             TreeNode cur = queue.poll();
//             //交换左右子树
//             TreeNode left = cur.left;
//             cur.left = cur.right;
//             cur.right = left;

//             if(cur.left!=null) queue.add(cur.left);
//             if(cur.right!=null) queue.add(cur.right);
//         }

//         return root;
//     }
// }