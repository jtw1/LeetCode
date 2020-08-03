// package LeetCodeTest;
// // [222] 完全二叉树的节点个数
// // https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
// public class Solu222 {
//     public int countNodes(TreeNode root) {
//         //一
//         //TC T(n)=T(n/2)+logn,一直下去，所以时间复杂度O(logn*logn)
//         //空间复杂度O(h) h是数高
//         if(root==null) return 0;
//         int right = countlevel(root.right);  //右子树的层数
//         int left = countlevel(root.left);    //左子树的层数

//         if (left==right) {
//             //当左层数等于右层数时，根据完全二叉树性质，左子树肯定是满二叉树
//             //左子树节点数为2^left-1,加上根节点1个，再对右子树递归，相加即总结点数
//             //由于移位运算比较快，2^left-1+1=(1<<left);注意运算符优先级所以打括号
//             return countNodes(root.right)+(1<<left);
//         }
//         //当左层数不等于右层数时，根据完全二叉树性质，右子树肯定是满二叉树
//         //同理对左子树递归，加右子树节点数+根节点
//         else{
//             return countNodes(root.left)+(1<<right);
//         }
//     }

//     //计算完全二叉树的层数
//     private int countlevel(TreeNode root){
//         int level=0;
//         while(root!=null){
//             level++;
//             root = root.left;
//         }
//         return level;
//     }

//     //二
//     //return root==null? 0:countNodes(root.left)+countNodes(root.right)+1;
// }