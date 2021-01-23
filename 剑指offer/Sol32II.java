import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 32-II 从上到下打印二叉树 p174
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @date 2021/1/18 0018-9:38
 */
public class Sol32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    //法二 递归实现
    List<List<Integer>> ret;
    public List<List<Integer>> levelOrder1(TreeNode root){
        ret=new ArrayList<>();
        recur(root,0);
        return ret;
    }
    public void recur(TreeNode root,int k){
        if(root!=null){
            if(ret.size()<=k) ret.add(new ArrayList());
            ret.get(k).add(root.val);
            recur(root.left,k+1);
            recur(root.right,k+1);
        }
    }
}
