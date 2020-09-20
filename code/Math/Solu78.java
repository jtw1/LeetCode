package LeetCodeTest;
/**
 * [78] 子集 
 * https://leetcode-cn.com/problems/subsets/
 */
import java.util.ArrayList;
import java.util.List;

public class Solu78 {
    public List<List<Integer>> subsets(int[] nums) {
        //法二 位运算
        List<List<Integer>> res = new ArrayList<>();
        //数组中每个数字都有选取和不选取两种状态，0为不选中，1为选中，则长度为n的数组共有2^n个子集，即1<<nums.length个
        int len = 1<<nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某个位置是1，就把数组中对应的数字添加到集合
                if(((i>>j) & 1)==1) path.add(nums[j]);
            }
            res.add(path);
        }
        return res;
        // List<List<Integer>> res = new ArrayList<>();
        
        // 
        // dfs(nums,0,path,res);
        // return res;
    }
    //法一，回溯
    private void dfs(int[] nums,int start,List<Integer> path,List<List<Integer>> res){
        res.add(new ArrayList<>(path));

        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,path,res);
            path.remove(path.size()-1);
        }       
    }
}
