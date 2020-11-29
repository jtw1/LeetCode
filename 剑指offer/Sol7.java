import java.util.HashMap;
import java.util.Map;

/**
 * @Description 面试题7 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @date 2020/11/24 0024-10:52
 */
public class Sol7 {
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
        int index = idx_map.get(root.val);    //得到根节点在中序遍历中的下标
        post_idx++;

        root.left = helper(left,index-1);   //递归得到左子树
        root.right = helper(index+1,right);  //递归得到右子树
        return root;
    }
}
