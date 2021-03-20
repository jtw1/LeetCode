/**
 * @Description 124 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @date 2021/3/20-11:02
 */
public class Sol124 {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    /**
     *
     * @param node
     * @return 二叉树中的一个节点的最大贡献值：在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径节点之和最大
     */
    public int maxGain(TreeNode node){
        if (node==null) return 0;
        // 递归计算左右节点的最大贡献值，
        // 只有最大贡献值大于0时，才会选取该节点
        int leftGain=Math.max(maxGain(node.left),0);
        int rightGain=Math.max(maxGain(node.right),0);
        // 节点的最大路径和取决于该节点的值和该节点左右节点的贡献值之和
        int priceNewPath=node.val+leftGain+rightGain;
        // 更新答案
        maxSum=Math.max(maxSum,priceNewPath);
        // 返回节点的最大贡献值
        return node.val+Math.max(leftGain,rightGain);
    }
}
