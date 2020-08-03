// package LeetCodeTest;
// // [110] 平衡二叉树
// // https://leetcode-cn.com/problems/balanced-binary-tree/description/
// public class Solu110 {
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;
//         //法一 TC:O(nlogn)   SC:O(n)
//         Queue<TreeNode> nQueue = new ArrayDeque<>();
//         nQueue.add(root);
//         while (!nQueue.isEmpty()) {
//             TreeNode node = nQueue.poll();
//             if (Math.abs(level(node.left)-level(node.right))>1) {
//                 return false;
//             }
            
//             if (node.left!=null) {
//                 nQueue.add(node.left); 
//             }
//             if (node.right!=null) {
//                 nQueue.add(node.right);  
//             }
//         }
//         return true;

//         //法二  TC:O(nlogn)   SC:O(n)
//         return Math.abs(level(root.left)-level(root.right))<=1
//                && isBalanced(root.left) && isBalanced(root.right);
//     }
//     public int level(TreeNode root){
//         if(root==null) return 0;
//         return Math.max(level(root.left),level(root.right))+1;
//     }

//     //法三  TC:O(n)   SC:O(n)
//     //自底向上遍历
//     public boolean isBalanced(TreeNode root) {
//         return recur(root)!=-1;
//     }
//     /**
//      * 当节点root 左 / 右子树的高度差 < 2 ：则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加 1（ max(left, right) + 1 ）；
//      * 当节点root 左 / 右子树的高度差 ≥2 ：则返回−1 ，代表此子树不是平衡树 。
//      * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
//      * 1.递归到最深处返回0，因为叶子节点的左右节点是空呀；此时max(left,right)=0 ,left和right表达式中的+1就是为了计数的，把叶子 节点这一层加上了
//      * 2.想象所有递归到最后第一步返回值都是1，然后往上一层想，叶子节点的父节点也会得到{max（left，right）+1} 的返回值  
//      * 3.递归往上统计树的高度
//      * @param root
//      * @return
//      */
//     private int recur(TreeNode root){
//         if(root==null)  return 0;
//         int left = recur(root.left);  //递归，一直递归到叶子节点，先返回0，再向上回调
//         if(left==-1) return -1;
//         int right =recur(root.right);
//         if(right==-1) return -1;
//         return Math.abs(left-right)<=1? Math.max(left, right)+1:-1;
//     }
    
// }