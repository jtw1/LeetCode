package LeetcodeTest;
/**
 * [538] 将二叉搜索树转化为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 题解：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/fan-zhong-xu-bian-li-9887-by-zui-weng-jiu-xian/
 */
public class Solu538 {
    /**
     * 这样我们只需要反序中序遍历该二叉搜索树，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
     */
    int sum=0;
    public TreeNode convertBST(TreeNode root){
        if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
}
