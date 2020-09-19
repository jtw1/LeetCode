package LeetCodeTest;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * [404] 左叶子之和 https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class Solu404 {
    public int sumOfLeftLeaves(TreeNode root) {
        //递归
        //TC：O(n)  SC:O(n)
        // int sum=0;
        // if(root==null) return 0;
        // if(root.left!=null && root.left.left==null && root.left.right==null) sum += root.left.val;
        // sum += sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        // return sum;

        //BFS 
        int sum=0;
        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left!=null) {
                if (isLeafNode(node.left)) {
                   sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }

            if (node.right!=null && !isLeafNode(node.right)) {
                queue.offer(node.right);
            } 
        }
        return sum;
    }

    public Boolean isLeafNode(TreeNode root){
        return root.left==null && root.right==null;
    }
}
