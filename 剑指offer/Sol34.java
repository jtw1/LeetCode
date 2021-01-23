import java.util.ArrayList;
import java.util.List;

/**
 * @Description 34 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @date 2021/1/20 0020-9:59
 */
public class Sol34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curPath=new ArrayList<>();
        recur(res,curPath,root,sum);
        return res;
    }

    public void recur(List<List<Integer>> res,List<Integer> curPath,TreeNode curNode,int sum){
        if(curNode==null) return;
        curPath.add(curNode.val);

        if(curNode.val==sum && curNode.left==null && curNode.right==null){
            res.add(new ArrayList<>(curPath));
        }else{
            recur(res,curPath,curNode.left,sum-curNode.val);
            recur(res,curPath,curNode.right,sum-curNode.val);
        }
        curPath.remove(curPath.size()-1);
    }
}
