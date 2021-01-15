import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 28 对称二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @date 2021/1/14 0014-20:47
 */
public class Sol28 {
    public boolean isSymmetric(TreeNode root) {
        //递归
        return subIsSymmetric(root,root);
    }

    private boolean subIsSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return subIsSymmetric(root1.left,root2.right) && subIsSymmetric(root1.right,root2.left);
    }

    //迭代
    // 前序遍历  根左右
    // 定义一种新的遍历，对称前序遍历：根右左
    //当前序遍历序列和对称前序遍历相同时，该二叉树就是对称的
    public boolean isSymmetric1(TreeNode root){
        if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode left=queue.poll(),right=queue.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;

            //这里要记住入队的顺序，他会每两个两个的出队。
            //左子节点的左子节点和右子节点的右子节点同时
            //入队，因为他俩会同时比较。
            //左子节点的右子节点和右子节点的左子节点同时入队，
            //因为他俩会同时比较
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
