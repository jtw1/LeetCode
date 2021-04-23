import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 958 二叉树的完全性检验
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * @date 2021/4/23 0023-9:37
 */
public class Solu958 {
    /**
     * 层次遍历
     * 对于一颗完全二叉树，遇到第一个空节点之后，不应该再出现非空节点
      * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>();   //offer(E e)  e可以为null
        //Queue<TreeNode> queue=new ArrayDeque<>();    //offer(E e)  e不可以为null，否则会报  NullPointerException
        queue.offer(root);
        boolean isEnd=false;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(isEnd && node!=null){
                return false;
            }
            if(node==null){
                isEnd=true;
                continue;
            }

            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }
}
