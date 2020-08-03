package LeetCodeTest;

// import javax.swing.tree.TreeNode;

// // [108] 将有序数组转换为二叉搜索树
// // https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
// public class Solu108 {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if(nums==null || nums.length==0) return null;
//         return BuildTree(nums, 0, nums.length-1);
//     }
//     //法一：TC:O(n)   SC:O(logn)即递归深度   n为数组长度
//     public TreeNode BuildTree(int[] nums,int left,int right){
//         if(left>right) return null;

//         int mid =left+(right-left)/2;
//         TreeNode root = new TreeNode(nums[mid]);
//         root.left = BuildTree(nums, left, mid-1);
//         root.right = BuildTree(nums, mid+1, right);

//         return root;
//     }
// }