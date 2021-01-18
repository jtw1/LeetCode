import java.util.*;

/**
 * @Description 32-III 从上到下打印二叉树 p176
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @date 2021/1/18 0018-10:27
 */
public class Sol32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int index=0;

        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level = new LinkedList<>();
            List<Integer> level1 = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node=queue.poll();
                if(index%2==0){
                    level.add(node.val);
                }else{
                    level.add(0,node.val);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            /**
             * 前面对index奇偶的判断可以替换成
             * if(res.size()%2==1) Collections.reverse(level);
             */
            res.add(level);
            index++;
        }
        return res;
    }
}
