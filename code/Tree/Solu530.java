// 530 二叉搜索树的最小值
// https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
// 二叉搜索树的中序遍历即为升序数组，考虑对升序数组 a 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
