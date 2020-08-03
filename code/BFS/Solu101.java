package LeetCodeTest;
// [101] 对称二叉树
// https://leetcode-cn.com/problems/symmetric-tree/description/

// import java.util.LinkedList;

// import javax.swing.tree.TreeNode;

// public class Solu101 {
//     //法一：递归
//     public boolean isSymmetric(TreeNode root) {
//         return check(root,root);
//     }
//     public boolean check(TreeNode p,TreeNode q){
//         if(p==null && q==null)  return true;
//         if(p==null || q==null)  return false;
//         return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);
//     }

//     //法二：迭代
//     //时间复杂度O(n)   空间复杂度O(n)
//     public boolean isSymmetric(TreeNode root) {
//         //根节点为空或根节点的左右节点都为空时，true
//         if(root==null || (root.left==null && root.right==null)){
//             return true;
//         }
//         //用队列保存节点
//         LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//         //依次将根节点的左右节点加入队列
//         queue.add(root.left);
//         queue.add(root.right);
//         //队列不为空时，执行循环
//         while (queue.size()>0) {
//             //从队列中依次取出两个节点，再比较这两个节点
//             TreeNode left = queue.removeFirst();
//             TreeNode right = queue.removeFirst();
//             //都为空时，继续循环
//             if(left==null && right==null)   continue;
//             //其中只有一个为空或两节点存放的值不相等时，false
//             if(left==null || right==null)   return false;
//             if(left.val!=right.val)         return false;
//             //依次将左节点的左节点，右节点的右节点，左节点的右节点，右节点的左节点放如队列
//             queue.add(left.left);
//             queue.add(right.right);

//             queue.add(left.right);
//             queue.add(right.left);
//         }
//         return true;
//     }
// }