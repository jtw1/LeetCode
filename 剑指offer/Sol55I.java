import java.util.LinkedList;

/**
 * @Description 55-I 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @date 2021/2/5 0005-9:31
 */
public class Sol55I {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //迭代
//    public int maxDepth1(TreeNode root) {
//        Queue<Pair<TreeNode,Integer>> stack=new LinkedList<>();
//        if(root!=null) stack.add(new Pair(root,1));
//        int depth=0;
//        while(!stack.isEmpty()){
//            Pair<TreeNode,Integer> cur=stack.poll();
//            root=cur.getKey();
//            int cur_depth=cur.getValue();
//            if(root!=null){
//                depth=Math.max(depth,cur_depth);
//
//                stack.add(new Pair(root.left,cur_depth+1));
//                stack.add(new Pair(root.right,cur_depth+1));
//            }
//        }
//        return depth;
//    }
}
