package LeetcodeTest;
/**
 * [701] 二叉树的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class Solu701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        //法一：递归
        // TC:O(n)  SC:O(logn),最坏O(n)
        // if(val > root.val)  root.right=insertIntoBST(root.right,val);
        // if(val < root.val)  root.left=insertIntoBST(root.left,val);
        // return root;
        
        //法二 迭代
        // TC:O(n)  SC:o(1)
        TreeNode pos = root;
        while (pos!=null) {
            if(val<pos.val){
                if(pos.left==null){
                    pos.left=new TreeNode(val);
                    break;
                }else{
                    pos=pos.left;
                }
            }else{
                if(pos.right==null){
                    pos.right=new TreeNode(val);
                    break;
                }else{
                    pos=pos.right;
                }
            }
        }
        return root;
    }
}
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
