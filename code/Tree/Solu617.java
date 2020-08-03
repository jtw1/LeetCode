package LeetCodeTest;

//import java.util.LinkedList;


// [617] 合并二叉树
// https://leetcode-cn.com/problems/merge-two-binary-trees/description/
// public class Solu617 {
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         //递归
//         // if(t1==null) return t2;
//         // if(t2==null) return t1;

//         // t1.val +=t2.val;
//         // t1.left=mergeTrees(t1.left, t2.left);
//         // t1.right=mergeTrees(t1.right, t2.right);

//         // return t1;

//         //迭代
//         if(t1==null || t2==null) return t1==null? t2:t1;
//         LinkedList<TreeNode> queue = new LinkedList<>();
//         queue.add(t1);
//         queue.add(t2);

//         while (queue.size()!=0) {
//             TreeNode r1 = queue.remove();
//             TreeNode r2 = queue.remove();
//             r1.val += r2.val;

//             if (r1.left!=null && r2.left!=null) {
//                 queue.add(r1.left);
//                 queue.add(r2.left);
//             } else if(r1.left==null){
//                 r1.left==r2.left;
//             }

//             if (r1.right!=null && r2.right!=null) {
//                 queue.add(r1.right);
//                 queue.add(r2.right);
//             } else if(r1.right==null){
//                 r1.right==r2.right;
//             }
//         }
//         return t1;
//     }
// }