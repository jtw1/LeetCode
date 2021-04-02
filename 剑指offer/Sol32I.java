
import java.util.*;

/**
 * @Description 32-I  从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @date 2021/1/17-11:23
 */
public class Sol32I {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> nodeDeque=new LinkedList<>();
        nodeDeque.push(root);

        while(!nodeDeque.isEmpty()){
            TreeNode node=nodeDeque.poll();
            res.add(node.val);
            if(node.left!=null){
                nodeDeque.add(node.left);
            }
            if(node.right!=null){
                nodeDeque.add(node.right);
            }
        }
        /**
         * int[] arr1 = res.stream().mapToInt(Integer::valueOf).toArray();
         */

        int[] ans=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=res.get(i);
        }
        return ans;
    }
}
