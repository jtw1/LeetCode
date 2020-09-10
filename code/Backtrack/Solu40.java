package LeetcodeTest;
// [40]组合总和2
// https://leetcode-cn.com/problems/combination-sum-ii/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solu40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(len==0) return res;

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates,int begin,int len,int target,Deque<Integer> path,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //需要先对数组排序
        for(int i=begin;i<len;i++){
            //大剪枝
            if(target-candidates[i]<0) break;
            //小剪枝，去除相同元素的影响
            if(i>begin && candidates[i]==candidates[i-1]) continue;
            path.addLast(candidates[i]);

            dfs(candidates,i+1,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }
}
