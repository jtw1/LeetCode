/**
 * @Description 68-II 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 * @date 2021/2/17-15:56
 */
public class Sol68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // 为什么说找到一个就可以。 因为
        // 1 如果 q 是 p 的子孙， 那么肯定先找到的是p，那么p就是 p和q 的公共祖先
        // 2 如果 q 不是 p 的子孙， 那么在到达p之前，肯定会先到达p和q的公共祖先r，然后分别到达p和q，也就可以返回r了
        // 判断当前节点是否为最近公共祖先
        // 递归终止条件  越过叶子节点直接返回null  root==p or root==q  直接返回root
        if(root==null || root==p || root==q) return root;
        // 在左子树中寻找最近公共节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 在右子树中寻找最近公共节点
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        //当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q，返回 null
        // if(left==null && right==null) return null; 这句可以不要，如果left,right同时为null，下面两句返回的也是null
        if(left==null) return right; //在左子树中未找到公共节点，返回右子节点
        if(right==null) return left;  //在右子树中未找到公共节点，返回左子节点
        return root; //left!=null && right!=null情况，说明p  q分别在root的异侧  root即为公共祖先
    }
}
