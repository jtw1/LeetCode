
/**
 * @Description 236 二叉树最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @date 2021/3/3 0003-9:56
 */
public class Solu236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // 递归终止条件
        if(root==null || root==p || root==q) return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null && right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
