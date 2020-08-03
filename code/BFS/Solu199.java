package LeetCodeTest;


// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;




// // [199] 二叉树的右视图
// // https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
// public class Solu199 {
//     //DFS  TC:O(n)  SC:O(n)
//     List<Integer> arr = new ArrayList<>();
//     public List<Integer> rightSideView(TreeNode root) {
//         dfs(root, 0);
//         return arr;
//     }
//     /**
//      * 以“根节点,右子树，左子树”的顺序遍历，保证每一层先访问到的都是最右边的节点
//      * @param root
//      * @param depth
//      */
//     private void dfs(TreeNode root,int depth){
//         if(root==null) return;
//         //此时根节点对应的depth是0，arr每层只添加每层第一个访问的元素
//         //depth==arr.size()时，表示dfs函数的参数列表的treeNode时该层访问的第一个节点
//         if (depth==arr.size()) {
//             arr.add(root.val);
//         }
//         depth++;
//         dfs(root.right, depth);
//         dfs(root.left, depth);
//     }


    //BFS  TC:O(n)  SC:O(n)  
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> arr = new ArrayList<>();
    //     if(root==null) return arr;

    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);

    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             if (node.left!=null) {
    //                 queue.offer(node.left);
    //             }
    //             if (node.right!=null) {
    //                 queue.offer(node.right);
    //             }
                
    //             //从左往右遍历，每层的最后一个元素加到arr中
    //             if (i==size-1) {
    //                 arr.add(node.val);
    //             }
    //         }
    //     }
    //     return arr;
    // } 
//}