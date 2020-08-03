// package LeetCodeTest;

// import java.util.LinkedList;


// //[112] 路径总和
// // https://leetcode-cn.com/problems/path-sum/description/
// public class Solu112 {
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if (root == null) return false;
//         //递归 TC:O(n)  SC :O(h),h为树的高度
//         sum -= root.val;
//         if(root.left==null && root.right==null) return sum==0;
//         return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
//         //迭代
//         LinkedList<TreeNode> nStack = new LinkedList<>();
//         LinkedList<Integer> sumStack = new LinkedList<>();
//         //从根节点开始模拟，剩余目标和为sum-root.val
//         nStack.add(root);
//         sumStack.add(sum-root.val);
        
//         TreeNode node;
//         int currSum;
//         //开始迭代：弹出当前元素，如果当前剩余目标和为 0 并且在叶子节点上返回 True
//         //如果剩余和不为零并且还处在非叶子节点上，将当前节点的所有孩子以及对应的剩余和压入栈中。
//         while (!nStack.isEmpty()) {
//             node = nStack.pollLast();
//             currSum = sumStack.pollLast();
//             if(node.left==null && node.right==null && currSum==0){
//                 return true;
//             }
//             //开始误以为这里的currSum连续减了node.left.val以及node.right.val,其实不是的
//             //事实是分别减了一次，下面两个currSum是一样的，相当于分别遍历左节点，右节点，并得到各自对应的剩余目标和
//             if(node.left != null){
//                 nStack.add(node.left);
//                 sumStack.add(currSum-node.left.val);
//             }

//             if(node.right != null){
//                 nStack.add(node.right);
//                 sumStack.add(currSum-node.right.val);
//             }
//         }
//         return false;
//     }
// }