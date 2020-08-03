package LeetcodeTest;

// import java.util.ArrayList;
// import java.util.Deque;
// import java.util.List;

import javax.swing.tree.TreeNode;

// [114] 二叉树展开为链表
// https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
public class Solu114 {
    public void flatten(TreeNode root) {
        //法一：先对二叉树前序遍历。获得个节点被访问的顺序，然后更新每个结点的左右节点信息，展开为单链表
        // List<TreeNode> list = new ArrayList<>();
        // preOrderTraversal(root, list);

        // for (int i = 1; i < list.size(); i++) {
        //     TreeNode pre = list.get(i-1),curr=list.get(i);
        //     pre.left=null;
        //     pre.right=curr;
        // }
        

    }
    //前序遍历(递归)
    // public void preOrderTraversal(TreeNode root,List<TreeNode> list) {
    //     if (root!=null) {
    //         list.add(root);
    //         preOrderTraversal(root.left, list);
    //         preOrderTraversal(root.right, list);
    //     }
    // }

    //前序遍历(迭代)
    // public void preOrderTraversal1(TreeNode root,List<TreeNode> list) {
    //     Deque<TreeNode> stack = new LinkedList<TreeNode>();
    //     TreeNode node=root;
    //     while (node!=null || !stack.isEmpty()) {
    //         while (node!=null) {
    //             list.add(node);
    //             stack.push(node);
    //             node=node.left;
    //         }
    //         node=stack.pop();
    //         node=node.right;
    //     } 
    // }

}