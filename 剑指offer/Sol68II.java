/**
 * @Description 68-II 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 * @date 2021/2/17-15:56
 */
public class Sol68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // 判断当前节点是否为最近公共祖先
        if(root==null || root==p || root==q) return root;
        // 在左子树中寻找最近公共节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 在右子树中寻找最近公共节点
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if(left==null) return right; //在左子树中未找到公共节点，返回右子节点
        if(right==null) return left;  //在右子树中未找到公共节点，返回左子节点
        return root; //left!=null && right!=null情况，root即为公共祖先
    }
}
