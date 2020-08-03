// package LeetCodeTest;

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;


// // [113] 路径总和 II
// // https://leetcode-cn.com/problems/path-sum-ii/description/
// public class Solu113 {
//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//         List<List<Integer>> result = new LinkedList<>();
//         List<Integer> curPath = new LinkedList<>();
//         recur(result, curPath, root, sum);
//         return result;
//     }
//     /**
//      * 每次遍历到的node放入curPath中，然后改变目标值为sum-node.val
//      * 如果满足条件，将当前节点值存入curPath，如果不满足，改变目标值为sum-node.val继续递归
//      * 当到达某一个leaf时，发现路径总和不满足条件，将curPath最后一项删除，并倒退回上一个node（体现：例如1-2-3-4，执行到4时，发现不满足条件，此时递归并未结束，倒退回上一层继续执行，可能要继续检测右支）
//      */
//     public void recur(List<List<Integer>> result,List<Integer> curPath,TreeNode curNode,int sum){
//         // 递归终止条件
//         if(curNode==null) return;
//         // 沿途结点必须选择，这个时候要做两件事：1、sum 减去这个结点的值；2、添加到 path 里
//         curPath.add(curNode.val);
//         //这里的sum是形参列表里的，每次递归都会改变
//         if (curNode.val==sum && curNode.left==null && curNode.right==null) {
//             result.add(new ArrayList<>(curPath));  //需要每次都new一个，不然会指向一个引用
//         }else{
//                 recur(result, curPath, curNode.left, sum-curNode.val);
//                 recur(result, curPath, curNode.right, sum-curNode.val);
//         }
//         curPath.remove(curPath.size()-1);  //每一次递归完了才会走到这一步
//     }
// }