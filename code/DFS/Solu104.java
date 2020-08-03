package LeetCodeTest;

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;



// [104] 二叉树的最大深度
// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
public class Solu104 {
    // public int maxDepth(TreeNode root) {
    //     //法一：递归法  总共n个节点
    //     //时间复杂度O(n)
    //     //空间复杂度 最坏情况O(n)【只有左节点或只有右节点，将递归调用n次】
    //     //最坏情况O(log n)【树是完全平衡的，树高为log n】
    //     if(root==null)   return 0;
    //     int leftHeight = maxDepth(root.left);
    //     int rightHeight = maxDepth(root.right);
    //     return Math.max(leftHeight, rightHeight)+1;

    //     //法一：迭代法
    //     //时间复杂度O(n),空间复杂度O(n)
    //     Queue<Pair<TreeNode,Integer>> stack = new LinkedList<>();
    //     if (root!=null) {
    //         stack.add(new Pair(root,1));
    //     }

    //     int depth=0;
    //     while (!(stack.isEmpty())) {
    //         Pair<TreeNode,Integer> current = stack.poll();
    //         root = current.getKey();
    //         int current_depth = current.getValue();
    //         if (root!=null) {
    //             depth = Math.max(depth, current_depth);
    //             //每遍历到新的一层时，current_depth+1，
    //             //并不是每往堆里面加一个节点，current_depth都加1
    //             //下面两个current_depth相同
    //             stack.add(new Pair(root.left,current_depth+1));
    //             stack.add(new Pair(root.right,current_depth+1));
    //         }
    //     }
    //     return depth;
    // }
}