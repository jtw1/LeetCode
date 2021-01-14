import java.util.Stack;

/**
 * @Description 27 二叉树的镜像 p159
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @date 2021/1/14 0014-17:13
 */
public class Sol27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return root;
        TreeNode tmp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(tmp);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return root;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);

            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
        return root;
    }
}
