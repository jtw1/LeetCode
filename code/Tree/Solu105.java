package LeetcodeTest;

import java.util.HashMap;
import java.util.Map;

/**
 * [105] 从中序遍历和前序遍历构造二叉树 与106类似
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solu105 {
    int post_idx;
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> idx_map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        post_idx=0;
        
        int index=0;
        for(Integer val:inorder){
            idx_map.put(val,index++);
        }
        return helper(0,inorder.length-1);
    }

    public TreeNode helper(int left,int right){
        if(left>right) return null;

        TreeNode root = new TreeNode(preorder[post_idx]);
        int index = idx_map.get(root.val);
        post_idx++;

        root.left = helper(left,index-1);
        root.right = helper(index+1,right);
        return root;
    }
}
