import javax.swing.tree.TreeNode;

/**
 * @Description 55-II 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @date 2021/2/7-10:30
 */
public class Sol55II {
    // top to bottom
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
    // bottom to top
    private int recur(TreeNode root){
        if(root==null) return 0;
        int left=recur(root.left);
        if(left==-1) return -1;
        int right=recur(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
