
/**
 * @Description 68-I 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @date 2021/2/17-14:47
 */
public class Sol68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor=root;
        /**
         * 算法过程：先假设祖先节点为root
         * 当p，q节点的值小于当前节点的值时，说明p，q节点都在当前节点的左子树，因此将当前节点移到他的左子节点
         * 当p，q节点的值大于当前节点的值时，说明p，q节点都在当前节点的右子树，因此将当前节点移到他的右子节点
         * 否则，当前节点的值介于p，q节点的值之间，说明当前节点就是p，q节点最近公共祖先
         */
        while(true){
            if(p.val<ancestor.val && q.val<ancestor.val){
                ancestor=ancestor.left;
            }else if(p.val>ancestor.val && q.val>ancestor.val){
                ancestor=ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }
}
