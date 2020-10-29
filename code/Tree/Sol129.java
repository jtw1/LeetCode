package Tree;
// [129] 求根到叶子节点的数字之和
// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/


  //Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * @Description
 * @date 2020/10/29 0029-14:17
 */
//每日一题10.29
public class Sol129 {
    public int sumNumbers(TreeNode root) {
        //TC:O(n)  SC:O(n)
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int preSum){
        if(root==null) return 0;
        int sum=preSum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }else{
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
