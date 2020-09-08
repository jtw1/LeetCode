package LeetcodeTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// [77] 组合
// https://leetcode-cn.com/problems/combinations/
public class Solu77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0||n<k) return res;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n,int k,int begin,Deque<Integer> path,List<List<Integer>> res){
        //递归终止条件是path的长度=k
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //i<=n-(k-path.size())+1可有效避免无效递归
        //遍历可能的搜索起点
        for(int i=begin;i<=n-(k-path.size())+1;i++){
            //向路径中添加一个数
            path.addLast(i);
            //下一轮搜索，搜索起点加一，因为不允许有重复元素出现
            dfs(n,k,i+1,path,res);
            //将path中最先加进来的数去除，再对剩下的数递归
            path.removeLast();
        }
    }
}
