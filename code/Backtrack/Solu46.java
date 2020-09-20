package LeetCodeTest;
/**
 * [46] 全排列 https://leetcode-cn.com/problems/permutations/
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solu46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length]; //用来标记数组中的数是否使用过
        dfs(nums,0,used,res,path);
        return res;
    }
    private void dfs(int[] nums, int depth,boolean[] used,List<List<Integer>> res,Deque<Integer> path){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
         // 在非叶子结点处，产生不同的分支，这一操作的语义是：
         //在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                dfs(nums,depth+1,used,res,path);
                //// 注意：下面这两行代码发生 「回溯」，
                //回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i]=false;
                path.removeLast();
            }         
        }
    }
}
