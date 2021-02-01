import java.util.ArrayList;
import java.util.List;

/**
 * @Description 54 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @date 2021/2/1 0001-9:27
 */
public class Sol54 {
    //法一 ：根据中序遍历序列 求该序列的第n-k个元素
    List<Integer> res=new ArrayList<>();
    public int kthLargest1(TreeNode root, int k) {
        res=inOrder(root);
        return res.get(res.size()-k);
    }
    public List<Integer> inOrder(TreeNode root){
        if(root==null) return new ArrayList<>();
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        return res;
    }

    //法一 ：根据中序遍历倒序的序列 求该序列的第k个元素 提前返回  beat 100%
    // 中序遍历倒序  右左根
    public int ans,k;
    public int kthLargest(TreeNode root, int k){
        this.k=k;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k==0) ans =root.val;
        dfs(root.left);
    }
}
