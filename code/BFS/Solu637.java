package LeetCodeTest;
// [637] 二叉树的层平均值
// https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;


public class Solu637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        
        if(root!=null) res.add((double)root.val);
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        dq.add(root);

        while(!dq.isEmpty()){
            int len = dq.size();
            double n=0;
            for(int i=0;i<len;i++){
                TreeNode node = dq.poll();
                n += node.val;
                if(node.left!=null){
                    dq.add(node.left);
                }
                if(node.right!=null){
                    dq.add(node.right);
                }
            }
            res.add((double)(n/len));
        }
        return res;
    }
}
