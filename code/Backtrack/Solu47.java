package LeetCodeTest;
/**
 * [47] 全排列2
 * https://leetcode-cn.com/problems/permutations-ii/
 * 看liweiwei题解
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solu47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,used,res,path);
        return res;
    }

    private void dfs(int[] nums, int depth,boolean[] used,List<List<Integer>> res,Deque<Integer> path){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            //used[i-1]是因为nums[i-1]在回退的过程中被撤销了选择
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                dfs(nums,depth+1,used,res,path);
                used[i]=false;
                path.removeLast();
            }         
        }
    }
}
