package LeetcodeTest;

//import java.util.LinkedList;
//import java.util.Queue;

// 104 二叉树最大深度
// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//public class Solu104 {
//    public int maxDepth(TreeNode root) {
//        //法一 递归 TC:O(n)  SC:O(logn),最坏O(n)[单边树]
//        if(root==null) return 0;
//        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

        //法二 BFS TC:O(n)  SC:O(logn),最坏O(n)[单边树]
//       if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();  //size为每一层的节点个数
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                //从左到右将每一层的非空节点添加到队列
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                size--;
//            }
//            //size减为0时，表示遍历完了一层，所以层数+1
//            ans++;
//        }
//        return ans;
        
        //法三 DFS TC:O(n)  SC:O(logn),最坏O(n)[单边树]
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        //DFS实现前序遍历，每个节点记录其所在深度
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//            TreeNode node = pair.first;
//            //DFS过程不断比较更新最大深度
//            maxDepth = Math.max(maxDepth, pair.second);
//            //记录当前节点所在深度
//            int curDepth = pair.second;
//            //当前节点的子节点入栈，同时深度+1
//          if (node.right != null) {
//                stack.push(new Pair<>(node.right, curDepth + 1));
//            }
//            if (node.left != null) {
//                stack.push(new Pair<>(node.left, curDepth + 1));
//            }
//        }
//        return maxDepth;

//    }
//}