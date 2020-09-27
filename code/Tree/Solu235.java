package LeetcodeTest;
/**
 * [235] 二叉树最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Solu235 {
    //TC:O(n)  SC:O(1)
    /**
     * 我们从根节点开始遍历；
       如果当前节点的值大于 p 和 q的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
       如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
       如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，p 和 q 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true){
            if(p.val<ancestor.val && q.val<ancestor.val){
                ancestor = ancestor.left;
            }else if(p.val>ancestor.val && q.val>ancestor.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }
}
