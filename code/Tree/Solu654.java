package LeetCodeTest;

// import javax.swing.tree.TreeNode;

// [654] 最大二叉树
// https://leetcode-cn.com/problems/maximum-binary-tree/description/
// public class Solu654 {
//     public TreeNode constructMaximumBinaryTree(int[] nums) {
//         return construct(nums, 0, nums.length);
//     }
//     //在下标为l<= i <r范围内找出二叉树根节点
//     public TreeNode construct(int[] nums,int l,int r){
//         if(l==r) return null;
//         int maxIndex = max(nums, l, r);
//         TreeNode root = new TreeNode(nums[maxIndex]);
//         root.left = construct(nums, 0, maxIndex);
//         root.right = construct(nums, maxIndex+1, r);
//         return root;
//     }
//     //在下标为l<= i <r范围内求最大元素的下标
//     public int max(int[] nums,int l,int r){
//         int maxIndex=l;
//         for (int i = l; i < r; i++) {
//             if (nums[maxIndex]<nums[i]) {
//                maxIndex=i; 
//             }
//         }
//         return maxIndex;
//     }
// }