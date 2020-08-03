package LeetCodeTest;

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;




// // [103] 二叉树的锯齿形层次遍历
// // https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
// public class Solu103 {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         if(root==null) return new ArrayList<List<Integer>>();

//         List<List<Integer>> res = new ArrayList<>();

//         LinkedList<TreeNode> nList = new LinkedList<>();
//         nList.add(root);
        
//         int flag=1;
//         while (!nList.isEmpty()) {
//             int size=nList.size();
//             flag++;
//             LinkedList<Integer> levelList = new LinkedList<>();
//             for(int i=0;i<size;i++){
//                 TreeNode node=nList.pop();
//                 if(flag%2==0){
//                     levelList.add(node.val);
//                 }else{
//                     levelList.push(node.val);
//                 }

//                 if (node.left!=null) {
//                     nList.add(node.left);
//                 }
//                 if (node.right!=null) {
//                     nList.add(node.right);
//                 }
//             }
//             res.add(levelList);
//         }
//         return res;
//     }

//     //法二 DFS TC:O(n)  SC:O(logn)
//     //root为当前节点   level为指定层数,res大小即为层数
    
//     //如果是第一次访问该层的节点，即该层的双端队列不存在。那么创建一个双端队列，并添加该节点到队列中。
//     // 如果当前层的双端队列已存在，根据顺序，将当前节点插入队列头部或尾部。
//     //最后，为每个节点调用该递归方法。

//     private void DFS(TreeNode root,int level,List<List<Integer>> res){
//         //level>res.size()时，表示到了新的一层，此时需要创建一个双端队列来添加该层的节点
//         if(level>=res.size()){
//             LinkedList<Integer> newlevel = new LinkedList<>();
//             newlevel.add(root.val);
//             res.add(newlevel);
//         }else{
//             if (level%2==0) {
//                 res.get(level).add(root.val);
//             } else {
//                 res.get(level).add(0, root.val);
//             }
//         }

//         if(root.left!=null) DFS(root.left, level+1, res);
//         if(root.right!=null) DFS(root.right, level+1, res);
//     }
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//         if(root==null) return new ArrayList<List<Integer>>();
//         List<List<Integer>> res = new ArrayList<>();
//         DFS(root, 0, res);

//         return res;
//     }
// }