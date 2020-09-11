package LeetcodeTest;
// [216] 组合总和3
// https://leetcode-cn.com/problems/combination-sum-iii/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class solu216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n>k*9) return res;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(k,n,1,path,res);
        return res;
    }
    private void dfs(int k, int n,int begin,Deque<Integer> path,List<List<Integer>> res){
        //终止条件
        if(path.size()==k || n<=0){
            //有符合要求的加入到res中
            if(path.size()==k && n==0)
               res.add(new ArrayList<Integer>(path));
            else return;
        }
        
        for(int i=begin;i<=9;i++){
            path.addLast(i);
            dfs(k,n-i,i+1,path,res);
            path.removeLast();
        }
    }
}
