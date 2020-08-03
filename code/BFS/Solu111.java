package LeetCodeTest;

//import java.util.LinkedList;

// [111] 二叉树的最小深度
// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
public class Solu111 {
    // public int minDepth(TreeNode root) {
    //     if(root==null)  return 0;
    //     if(root.left==null && root.right==null)  return 1;
    //     int mindepth = Integer.MAX_VALUE;
    //     if (root.left!=null) {
    //         mindepth = Math.min(mindepth, minDepth(root.left));
    //     }
    //     if (root.right!=null) {
    //         mindepth = Math.min(mindepth, minDepth(root.right));
    //     }      
    //     return mindepth+1;

    //     //DFS(深度优先搜索),每个节点都要遍历
    //     //时间复杂度O(n)    空间复杂度O(n)
    //     LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
    //     if (root==null) {
    //         return 0;
    //     } else {
    //         stack.add(new Pair(root,1));
    //     }

    //     int mindepth = Integer.MAX_VALUE;
    //     while (!(stack.isEmpty())) {
    //         Pair<TreeNode,Integer> current = stack.pollLast();
    //         root = current.getKey();
    //         int curr_depth = current.getValue();
    //         if(root.left==null && root.right==null){
    //             mindepth = Math.min(mindepth, curr_depth);
    //         }
    //         if(root.left!=null){
    //             stack.add(new Pair(root.left,curr_depth+1));
    //         }
    //         if(root.right!=null){
    //             stack.add(new Pair(root.right,curr_depth+1));
    //         }
    //     }
    //     return mindepth;


    //     //BFS(广度优先搜索),第一个访问到的叶子就是最小深度的节点，这样就不用遍历所有的节点了
    //     //时间复杂度O(n)    空间复杂度O(n)
    //     LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
    //     if (root==null) {
    //         return 0;
    //     } else {
    //         stack.add(new Pair(root,1));
    //     }

    //     int mindepth=0;
    //     while (!(stack.isEmpty())) {
    //         Pair<TreeNode,Integer> current = stack.poll();
    //         root = current.getKey();
    //         mindepth = current.getValue();
    //         if(root.left==null && root.right==null){
    //             break;
    //         }
    //         if(root.left!=null){
    //             stack.add(new Pair(root.left,mindepth+1));
    //         }
    //         if(root.right!=null){
    //             stack.add(new Pair(root.right,mindepth+1));
    //         } 
    //     }
    //     return mindepth;
    // } 
}