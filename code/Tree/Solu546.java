/**
 * @Description 546 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @date 2021/3/16 0016-11:27
 */
public class Solu546 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root){
        ans=1;
        depth(root);
        return ans-1;  //路径长度为该路径经过的结点数目减一
    }

    private int depth(TreeNode node){
        if (node==null) return 0;
        // 分别计算左儿子为根的子树深度和右儿子为根的子树深度（到叶子节点的节点个数）
        int left=depth(node.left);
        int right=depth(node.right);
        ans=Math.max(ans,left+right+1);
        return Math.max(left,right)+1;  // 返回该节点为根的子树的深度
    }

}
